import java.util.*;

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

class Obj {
    Node node;
    int HD;

    public Obj(Node node, int num) {
        this.node = node;
        HD = num;
    }
}

public class verticalOrder {
    public static List<List<Integer>> verticalOrderTraversal(Node root) {
        List<List<Integer>> lst = new ArrayList<>();
        Queue<Obj> queue = new LinkedList<>();
        queue.add(new Obj(root, 0));

        Obj cur;

        int min = 0;
        int max = 0;

        lst.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            cur = queue.remove();

            lst.get(cur.HD - min).add(cur.node.val);
            if (cur.node.left != null) {
                queue.add(new Obj(cur.node.left, cur.HD - 1));
                if (cur.HD - 1 < min) {
                    lst.add(0, new ArrayList<>());
                    min--;
                }
            }
            if (cur.node.right != null) {
                queue.add(new Obj(cur.node.right, cur.HD + 1));
                if (cur.HD + 1 > max) {
                    lst.add(new ArrayList<>());
                    max++;
                }
            }
        }

        return lst;
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nodes: ");
        String[] in = sc.nextLine().split(" ");
        sc.close();

        Node root = buildTree(in);
        System.out.print("Inorder traversal: ");
        inorderTraversal(root);

        System.out.println("\nVertical Order traversal: ");
        List<List<Integer>> res = verticalOrderTraversal(root);
        for (List<Integer> lst : res) {
            for (int i : lst)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}