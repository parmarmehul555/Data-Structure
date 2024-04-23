import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int idx = -1;

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildBinaryTree(nodes);
        System.out.println(calculateHeight(root));
    }

    public static Node buildBinaryTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.lptr = buildBinaryTree(nodes);
        newNode.rptr = buildBinaryTree(nodes);
        return newNode;
    }

    //Time Complexity ==>> O(n)
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.lptr);
        preOrder(root.rptr);
    }

    //Time Complexity ==>> O(n)
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.lptr);
        System.out.print(root.data+" ");
        inOrder(root.rptr);
    }
    
    //Time Complexity ==>> O(n)
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.lptr);
        postOrder(root.rptr);
        System.out.print(root.data+" ");
    }

    //Time Complexity ==>> O(n)
    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(current == null){
                System.out.println();
                if(queue.isEmpty()){
                    return;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(current.data+" ");
                if(current.lptr != null){
                    queue.add(current.lptr);
                }
                if(current.rptr != null){
                    queue.add(current.rptr);
                }
            }
        }
    } 

    //Time Complexity ==>> O(n)
    public static int countNode(Node root){
        if(root == null) return 0;

        int leftNodes = countNode(root.lptr);
        int rightNodes = countNode(root.rptr);
        return leftNodes+rightNodes+1;
    }

    //Time Complexity ==>> O(n)
    public static int sumOfNodes(Node root){
        if(root == null) return 0;

        int leftNodesSum = sumOfNodes(root.lptr);
        int rightNodeSum = sumOfNodes(root.rptr);
        return leftNodesSum + rightNodeSum + root.data;
    }

    //Time Complexity ==>> O(n)
    public static int calculateHeight(Node root){
        if(root == null) return 0;
        int leftHeight = calculateHeight(root.lptr);
        int rightHeight = calculateHeight(root.rptr);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1; 
    }

    
}

class Node {
    int data;
    Node lptr;
    Node rptr;

    Node(int data) {
        this.data = data;
        this.lptr = null;
        this.rptr = null;
    }
}
