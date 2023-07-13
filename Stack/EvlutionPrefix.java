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

        for(int i=0;i<s.length();i++){
            int a=0,b=0;
            char c = s.charAt(i);
            switch(c){
                case '+': a = stack.pop();
                          b = stack.pop();
                          stack.push((a+b));
                          break;
                
                case '-': a = stack.pop();
                          b = stack.pop();
                          stack.push((a-b));
                          break; 

                case '*': a = stack.pop();
                          b = stack.pop();
                          stack.push((a*b));
                          break;
                
                case '/': a = stack.pop();
                          b = stack.pop();
                          stack.push((a/b));
                          break;

                case '^': a = stack.pop();
                          b = stack.pop();
                          stack.push((int)Math.pow(a,b));
                          break;
                
                default: stack.push(Character.getNumericValue(s.charAt(i)));
            }   
        }
        System.out.println(stack.pop());
    }
}