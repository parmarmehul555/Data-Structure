import java.util.*;

public class EvalutionPostfix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String s = sc.next();
        Stack<Integer> stack = new Stack<>();
        
        String[] strArr = s.split(",");
        for(int i=0;i<strArr.length;i++){
            int a=0,b=0;
            String ch = strArr[i];
            switch(ch){
                case "+": a = stack.pop();
                          b = stack.pop();
                          stack.push((b+a));
                          break;
                
                case "-": a = stack.pop();
                          b = stack.pop();
                          stack.push((b-a));
                          break; 

                case "*": a = stack.pop();
                          b = stack.pop();
                          stack.push((b*a));
                          break;
                
                case "/": a = stack.pop();
                          b = stack.pop();
                          stack.push((b/a));
                          break;

                case "^": 
                case "$": a = stack.pop();
                          b = stack.pop();
                          stack.push((int)Math.pow(b,a));
                          break;

                default: stack.push((Integer.valueOf(ch)));
            }
        }
        System.out.println(stack.pop());
    }
}