import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix string: ");
        String str = sc.next();
        Infix in = new Infix(str.length());

        String postfix = "";

        for (int i = 0; i < str.length(); i++) {
            char c = (str.charAt(i));
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                postfix += c;
            } else if (c == '(') {
                in.push(c);
            } else if (c == ')') {
                while (!in.isEmpty() && in.peep() != '(') {
                    postfix += in.pop();

                }
                if (!in.isEmpty() && in.peep() == '(') {
                    in.pop();

                }
            } else {

                while (!in.isEmpty() && in.checkPrecedence(c) <= in.checkPrecedence(in.peep())) {
                    postfix += in.pop();
                }
                in.push(c);
            }

        }
        while (!in.isEmpty()) {
            postfix += in.pop();
        }
        System.out.println(postfix);
    }
}

class Infix {
    int n;
    char[] stack;
    int top;

    Infix(int n) {
        this.n = 100;
        stack = new char[n];
        top = 0;
    }

    public void push(char value) {
        if (top > n) {
            System.out.println("Stack overflow!");
        } else {
            stack[top++] = value;
            System.out.println("value is pushed" + value + "at " + (top - 1));
        }
    }

    public char pop() {
        if (top < 0) {
            System.out.println("stack underflow!");
        }
        System.out.println("value is poped" + stack[top - 1] + "at " + (top - 1));
        return stack[--top];
    }

    public char peep() {
        if (top < 0) {
            System.out.println("Stack underflow!");
        }
        char temp = stack[top - 1];
        return temp;
    }

    public boolean isEmpty() {
        if (top <= 0) {
            return true;
        }
        return false;
    }

    public int checkPrecedence(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;

            case '*':
                return 2;
            case '/':
                return 2;

            case '^':
                return 3;
            case '$':
                return 3;
            default:
                return -1;
        }

    }
}