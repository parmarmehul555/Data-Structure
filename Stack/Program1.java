import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackDemo sd = new StackDemo();
        int choice, element, position, value;

        do {
            System.out.println("Stack Opetions");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peep");
            System.out.println("4. change");
            System.out.println("5. display");
            System.out.println("0. exit");

            System.out.println("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element onto stack: ");
                    element = sc.nextInt();
                    sd.push(element);
                    break;

                case 2:
                    sd.pop();
                    break;

                case 3:
                    sd.peep();
                    break;

                case 4:
                    System.out.println("Enter position: ");
                    position = sc.nextInt();
                    System.out.println("Enter new value: ");
                    value = sc.nextInt();
                    sd.change(position, value);
                    break;

                case 5:
                    sd.display();
                    break;

                case 0:
                    System.out.println("exiting");
                    break;

                default:
                    System.out.println("Invalied choise! Enter valid number");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}

class StackDemo {
    Scanner sc = new Scanner(System.in);
    int n = 100;
    int[] stack = new int[n];
    int top = -1;  

    public void push(int element) {
        if (top > n) {
            System.out.println("Stack is overflow");
        } else {
            stack[++top] = element;
            System.out.println("Pushed element: " + element);
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is underflow!");
        } else {
            int element = stack[top--];
            System.out.println("Poped element is " + element);
        }
    }

    public void peep() {
        if (top == -1) {
            System.out.println("Stack is underflow!!");
        } else {
            System.out.println("Peeped element: " + stack[top]);
        }
    }

    public void change(int position, int value) {
        if (position > n || position < 0) {
            System.out.println("Invalied position!");
        } else {
            stack[position] = value;
            System.out.println("value changed at position " + position + " " + value);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >=0; i--) {
                System.out.println(stack[i] + " ");
            }
        }
    }
}