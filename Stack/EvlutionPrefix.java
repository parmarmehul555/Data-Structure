import java.util.*;

public class EvlutionPrefix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String str = sc.next();
        String s = "";
        for(int i=str.length()-1;i>=0;i--){
            s += str.charAt(i);
        }

        Stack<Integer> stack = new Stack<>();
        String[] strArr = s.split(",");
        for(int i=0;i<strArr.length;i++){
            int a=0,b=0;
            String ch = strArr[i];
            switch(ch){
                case "+": a = stack.pop();
                          b = stack.pop();
                          stack.push((a+b));
                          break;
                
                case "-": a = stack.pop();
                          b = stack.pop();
                          stack.push((a-b));
                          break; 

                case "*": a = stack.pop();
                          b = stack.pop();
                          stack.push((a*b));
                          break;
                
                case "/": a = stack.pop();
                          b = stack.pop();
                          stack.push((a/b));
                          break;

                case "^": 
                case "$": a = stack.pop();
                          b = stack.pop();
                          stack.push((int)Math.pow(a,b));
                          break;

                default: stack.push((Integer.valueOf(ch)));
            }
        }
        System.out.println(stack.pop());
    }
}