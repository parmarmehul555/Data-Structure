import java.util.*;

public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choise;
        QueueApply q = new QueueApply();

        do {
            System.out.println("Enter 1. insert\nEnter 2. delete\nEnter 3. display\nEnter 0. Exit");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Enter element to insert: ");
                    int element = sc.nextInt();
                    q.insert(element);
                    break;

                case 2:
                    int temp = q.delete();
                    System.out.println("Deleted element is " + temp);
                    break;

                case 3:
                    q.display();
                    break;

                case 0:
                    System.out.println("Program completed successfully!");
                    break;

                default:
                    System.out.println("Enter valid choise!");
                    break;
            }
        } while (choise != 0);
    }
}

class QueueApply {
    int n;
    int[] queue;
    int f, r;

    QueueApply() {
        n = 3;
        queue = new int[n];
        f = -1;
        r = -1;
    }

    public void insert(int value) {
        if (r == (n - 1)) {
            r = -1;
        }
        queue[++r] = value;
        if (f == -1) {
            f = 0;
        } else if (f == r) {
            System.out.println("Queue overflow!");
        }
    }

    public int delete() {
        int y = 0;
        if (f == -1) {
            System.out.println("Queue underflow!");
        } else {
            y = queue[f];
            queue[f]=0;
            f++;
            if (f == r) {
                r = -1;
                f = -1;
            }
            if (f == n) {
                f = -1;
            }
        }
        return y;
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.println("Element of queue is : " + queue[i]);
        }
    }
}