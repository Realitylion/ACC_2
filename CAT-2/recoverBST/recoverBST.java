import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int num) {
        val = num;
        left = null;
        right = null;
    }
}

public class recoverBST {
    static Node buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].charAt(0) == 'N')
            return null;

        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            Node cur = queue.remove();
            if (nodes[i].charAt(0) != 'N') {
                cur.left = new Node(Integer.parseInt(nodes[i]));
                queue.add(cur.left);
            }
            i++;

            if (i == nodes.length)
                break;
            if (nodes[i].charAt(0) != 'N') {
                cur.right = new Node(Integer.parseInt(nodes[i]));
                queue.add(cur.right);
            }
            i++;
        }

        return root;
    }

    static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    static Node recover(Node root) {
        Stack<Node> stk = new Stack<>();
        Node[] swapped = new Node[2];
        Node cur = root;
        Node lastProcessed = null;

        while (!stk.empty() || cur != null) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }

            cur = stk.pop();
            if (lastProcessed != null && lastProcessed.val > cur.val) {
                if (swapped[0] == null) {
                    swapped[0] = lastProcessed;
                    swapped[1] = cur;
                } else {
                    swapped[1] = cur;
                    break;
                }
            }

            lastProcessed = cur;
            cur = cur.right;
        }

        int temp = swapped[0].val;
        swapped[0].val = swapped[1].val;
        swapped[1].val = temp;

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nodes: ");
        String[] in = sc.nextLine().split(" ");
        sc.close();

        Node root = buildTree(in);
        System.out.print("Inorder traversal before recovery: ");
        inorderTraversal(root);

        recover(root);

        System.out.print("\nInorder traversal after recovery: ");
        inorderTraversal(root);
    }
}
