import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class boundaryTreeTraversal {
    static Node buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].charAt(0) == 'N')
            return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        Node cur;

        while (!queue.isEmpty() && i < nodes.length) {
            cur = queue.remove();
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

    static List<Integer> getLeftNodes(Node root) {
        List<Integer> lst = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            lst.add(cur.val);
            if (cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }

        return lst;
    }

    static void printLeaves(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    static List<Integer> getRightNodes(Node root) {
        List<Integer> lst = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            lst.add(cur.val);
            if (cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }

        return lst;
    }

    static void boundaryTraversal(Node root) {
        if (root == null)
            return;

        // printing nodes on the left wall (except the last one)
        List<Integer> leftNodes = getLeftNodes(root);
        for (int i = 0; i < leftNodes.size() - 1; i++)
            System.out.print(leftNodes.get(i) + " ");

        // printing all leaf nodes
        printLeaves(root);

        // printing the right wall nodes in reverse (except first and last ones)
        List<Integer> rightNodes = getRightNodes(root);
        for (int i = rightNodes.size() - 2; i > 0; i--)
            System.out.print(rightNodes.get(i) + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nodes: ");
        String[] in = sc.nextLine().split(" ");
        sc.close();

        Node root = buildTree(in);
        System.out.print("Inorder traversal: ");
        inorderTraversal(root);

        System.out.print("\nBoundary traversal: ");
        boundaryTraversal(root);
    }
}