import java.util.Scanner;

public class Recognize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackDemo sd = new StackDemo();

        System.out.println("Enter string: ");
        String str = sc.next();
        int tempIndex = 0;
        boolean isValid = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c' || str.charAt(i) == ' ') {
                tempIndex = i;
                break;
            } else {
                char c = str.charAt(i);
                sd.push(c);
            }
        }

        for (int i = tempIndex + 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                break;
            } else {
                char c = str.charAt(i);
                char temp = sd.pop();
                if (c != temp) {
                    System.out.println("Invalid string");
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
        }

        if (isValid) {
            System.out.println("Valied string!");
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
        top = 1;
        stack[top] = 'c';
    }

    public void push(char c) {
        if (top > n) {
            System.out.println("Stakc is overflow!");
        } else {
            stack[++top] = c;
        }
    }

    public char pop() {
        if (top < 1) {
            System.out.println("Stack is underflow!");
        }
        return stack[top--];
    }
}