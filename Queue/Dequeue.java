import java.util.Scanner;

public class Dequeue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DequeueApply dq = new DequeueApply();

        int choise=0;

        do{
            System.out.println("Enter 1. Insert_rear\nEnter 2. Insert_front\nEnter 3. Delete_front\nEnter 4. Delete_rear\nEnter 5. Display\nEnter 0. Exit");
            choise =sc.nextInt();

            switch(choise){
                case 1: System.out.println("Enter element to insert from rear: ");
                        int value = sc.nextInt();
                        dq.insert_rear(value);
                        break;

                case 2: System.out.println("Enter element to insert from front: ");
                        int element = sc.nextInt();
                        dq.insert_front(element);
                        break;

                case 3: int temp = dq.delete_front();
                        System.out.println("Deleted element form front is "+temp);
                        break;
                
                case 4: int temp1 = dq.delete_rear();
                        System.out.println("Deleted element form rear is "+temp1);
                        break;
                
                case 5: dq.display();
                        break;

                case 0: System.out.println("Program completed successfully!");
                        break;

                default: System.out.println("Enter valid number!");
                        break;
            }
        }while(choise!=0);
    }
}

class DequeueApply{
    int n,f,r;
    int[] dequeue;

    DequeueApply(){
        n=5;
        f=-1;
        r=-1;
        dequeue  = new int[n];
    }

    public void insert_rear(int value){
        if(r==n){
            System.out.println("Queue overflow!");
        }
        else{
            dequeue[++r] = value;
            if(f==-1){
                f=0;
            }
        }

    }

    public int delete_front(){
        if(r==-1){
            System.out.println("Queue underflow!");
        }
        else if(f==r){
            f=0;
            r=0;
        }
        return dequeue[f++];
    }

    public void insert_front(int value){
        if(f==0){
            System.out.println("Queue overflow!");
        }
        else{
            if(f==-1){
                f=0;
                r=0;
            }
            else{
                dequeue[--f] = value;
                System.out.println("Element iserted at "+f);
            }
        }
    }

    public int delete_rear(){
        int y=0;
        if(r==-1){
            System.out.println("Queue underflow!");
        }
        else{
            y=dequeue[r--];
            if(f==r){
                f=-1;
                r=-1;
            }
        }
        return y;
    }

    public void display(){
        if(f==-1){
            System.out.println("queue empty!");
        }else{
            for(int i=f;i<=r;i++){
                System.out.println("Element of DEQUEUE is "+dequeue[i]);
            }
        }
    }
}