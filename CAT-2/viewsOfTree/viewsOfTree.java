import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class viewsOfTree {
    static Node buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].charAt(0) == 'N')
            return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;

        int cur;
        Node newNode, curNode;

        while (!queue.isEmpty() && i < nodes.length) {
            curNode = queue.remove();
            if (nodes[i].charAt(0) != 'N') {
                cur = Integer.parseInt(nodes[i]);
                newNode = new Node(cur);
                curNode.left = newNode;
                queue.add(newNode);
            }
            i++;
            if (i == nodes.length)
                break;
            if (nodes[i].charAt(0) != 'N') {
                cur = Integer.parseInt(nodes[i]);
                newNode = new Node(cur);
                curNode.right = newNode;
                queue.add(newNode);
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

    static void leftView(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // level order traversal, print leftmost node in each level
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node curNode = queue.remove(); // only the nodes in the current level are in the queue
                if (i == 0)
                    System.out.print(curNode.val + " "); // print only the leftmost node in each level
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
        }
    }

    static void rightView(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // level order traversal, print rightmost node in each level
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node curNode = queue.remove(); // only the nodes in the current level are in the queue
                if (i == 0)
                    System.out.print(curNode.val + " "); // print only the rightmost node in each level
                if (curNode.right != null)
                    queue.add(curNode.right);
                if (curNode.left != null)
                    queue.add(curNode.left);
            }
        }
    }

    static class NodeWithHD {
        Node node;
        int HD;

        NodeWithHD(Node node, int HD) {
            this.node = node;
            this.HD = HD;
        }
    }

    static void topView(Node root) {
        if (root == null)
            return;
        Queue<NodeWithHD> queue = new LinkedList<>();
        queue.add(new NodeWithHD(root, 0));

        int leftMost = 0;
        int rightmost = 0;

        // for each horizontal distance, there is exactly one top most node
        // we store the top most node values for each HD in a hashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        NodeWithHD curObj;
        while (!queue.isEmpty()) {
            curObj = queue.remove();

            // if topmost element for a HD has been found already,
            // we should not further update this value
            if (!map.containsKey(curObj.HD))
                map.put(curObj.HD, curObj.node.val);

            // in case we come across two nodes at the topmost level for a HD
            // we need to take the left most node in top view
            // hence we push left node to the queue first, then right node
            if (curObj.node.left != null) {
                queue.add(new NodeWithHD(curObj.node.left, curObj.HD - 1));
                leftMost = Math.min(leftMost, curObj.HD - 1);
            }
            if (curObj.node.right != null) {
                queue.add(new NodeWithHD(curObj.node.right, curObj.HD + 1));
                rightmost = Math.max(rightmost, curObj.HD + 1);
            }
        }

        // printing top most value at each HD
        for (int i = leftMost; i <= rightmost; i++)
            System.out.print(map.get(i) + " ");
    }

    static void bottomView(Node root) {
        if (root == null)
            return;

        Queue<NodeWithHD> queue = new LinkedList<>();
        queue.add(new NodeWithHD(root, 0));

        int leftMost = 0;
        int rightMost = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        NodeWithHD curObj;

        while (!queue.isEmpty()) {
            curObj = queue.remove();

            // since we need bottom most value for each HD, we update the value for each
            // node we come across (irrespective of if it has been visited before)

            // and since right nodes come after the left nodes in this traversal,
            // we get the rightmost and bottom most node's value for each HD
            map.put(curObj.HD, curObj.node.val);

            if (curObj.node.left != null) {
                queue.add(new NodeWithHD(curObj.node.left, curObj.HD - 1));
                leftMost = Math.min(curObj.HD - 1, leftMost);
            }
            if (curObj.node.right != null) {
                queue.add(new NodeWithHD(curObj.node.right, curObj.HD + 1));
                rightMost = Math.max(curObj.HD + 1, rightMost);
            }
        }

        for (int i = leftMost; i <= rightMost; i++)
            System.out.print(map.get(i) + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tree nodes: ");
        String[] in = sc.nextLine().split(" ");
        sc.close();

        Node root = buildTree(in);
        System.out.print("Inorder traversal of tree: ");
        inorderTraversal(root);

        System.out.print("\nLeft view of tree: ");
        leftView(root);
        System.out.print("\nLeft view of tree: ");
        rightView(root);
        System.out.print("\nTop view of tree: ");
        topView(root);
        System.out.print("\nBottom view of tree: ");
        bottomView(root);
    }
}