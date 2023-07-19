import java.util.Scanner;
public class QueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QueueApply q = new QueueApply();
        int choise;

        do{
            System.out.println("Enter 1.insert\nEnter 2. delete\nenter 3. display\nEnter 0. exit");
            choise = sc.nextInt();
            if(choise==1){
                System.out.println("Enter char to insert: ");
                char c = sc.next().charAt(0);
                q.insert(c);
                System.out.println("Inserted element is: "+c);
            }
            else if(choise == 2){
                char temp=q.delete();
                System.out.println("Deleted element is : "+temp);
            }
            else if(choise == 3){
                q.display();
            }
            else if(choise == 0){
                System.out.println("Program completed!");
                break;
            }
        }while(choise!=0);
    }
}

class QueueApply{
    int f;
    int r;
    char[] queue;
    int n;

    QueueApply(){
        n=100;
        queue = new char[n];
        f=0;
        r=0;
    }

    public  void insert(char value) {
        if(r >= n){
            System.out.println("Queue overflow!");
        }
        else{
            r=r+1;
            queue[r] = value;
            if(f==0){
                f=f+1;
            }
        }
    }

    public char delete(){
        if(r == 0){
            System.out.println("Stack underflow!");
        }
        else if(f==r){
            r=0;
            f=0;
        }
        return queue[f++];
    }

    public void display(){
        for(int i=f;i<=r;i++){
            System.out.print(queue[i]);
        }
    }
    
}