import java.util.*;

public class EvalutionPostfix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String s = sc.next();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            int a=0,b=0;
            char c = s.charAt(i);
            switch(c){
                case '+': a = stack.pop();
                          b = stack.pop();
                          stack.push((b+a));
                          break;
                
                case '-': a = stack.pop();
                          b = stack.pop();
                          stack.push((b-a));
                          break; 

                case '*': a = stack.pop();
                          b = stack.pop();
                          stack.push((b*a));
                          break;
                
                case '/': a = stack.pop();
                          b = stack.pop();
                          stack.push((b/a));
                          break;

                case '^': a = stack.pop();
                          b = stack.pop();
                          stack.push((int)Math.pow(b,a));
                          break;
                
                default: stack.push(Character.getNumericValue(s.charAt(i)));
            }   
        }
        System.out.println(stack.pop());
    }
}