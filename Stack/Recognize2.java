import java.util.Scanner;

public class Recognize2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.next();

        StackDemo sd = new StackDemo();
        char pushc;
        int counta = 0, countb = 0;
        boolean isValid = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                pushc = str.charAt(i);
                sd.push(pushc);
                isValid = true;
            } else if (str.charAt(i) == 'b') {
                pushc = str.charAt(i);
                sd.push(pushc);
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }

        char popc;
        for (int i = 0; i < str.length(); i++) {
            popc = str.charAt(i);
            if (popc == 'a') {
                counta++;
            } else if (popc == 'b') {
                countb++;
            }
        }
        if (isValid) {
            if (counta == countb) {
                System.out.println("Valid stirng!");
            } else {
                System.out.println("Invalid String!");
            }
        }
        else{
            System.out.println("Invalid String!");
        }

    }
}

class StackDemo {
    int n;
    char[] stack;
    int top;

    public StackDemo() {
        n = 100;
        stack = new char[n];
        top = 0;
    }

    public void push(char value) {
        if (top > n) {
            System.out.println("Stack overflow!");
        } else {
            stack[++top] = value;
        }
    }

    public char pop() {
        if (top == 0) {
            System.out.println("Stack underflow!");
        }
        return stack[top--];
    }
}