import java.util.*;
public class InfixToPrefixGeneric {
    public static int checkPrec(char c){
        switch(c){
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s = sc.next();
        String str="";

        for(int i=s.length()-1;i>=0;i--){
            char temp = s.charAt(i);
            if(temp == '('){
                temp = ')';
            }
            else if(temp == ')'){
                temp = '(';
            }
            str += temp;
        }

        System.out.println(str);
        String prefix="";
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')){
                prefix += c;
                System.out.println("char");
            }
            else if(c=='('){
                stack.push(c);
                System.out.println("bracket");
            }
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    prefix += stack.pop();
                    System.out.println("pop in while");
                }
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
            }
            else{
                while(!stack.isEmpty() && checkPrec(c) <= checkPrec(stack.peek())){
                    prefix += stack.pop();
                System.out.println("pecedence check and pop");
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            prefix+=stack.pop();
        }
        System.out.println(prefix+"======================");
        String purePrifix="";

        for(int i=prefix.length()-1;i>=0;i--){
            char temp = prefix.charAt(i);
            purePrifix += temp;
        }

        System.out.println("Prefix expression is "+ purePrifix);
    }
}
