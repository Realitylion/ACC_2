import java.util.Scanner;

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int num) {
        val = num;
        next = null;
        prev = null;
    }
}

public class mergeSortDLL {

    static Node insertNode(Node head, int num) {
        Node newNode = new Node(num);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        newNode.prev = temp;
        temp.next = newNode;

        return head;
    }

    static void printDLL(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    static Node split(Node node) {
        Node fast = node, slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        temp.prev = null;
        slow.next = null;
        return temp;
    }

    static Node merge(Node node1, Node node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            node1.next.prev = node1;
            node1.prev = null;
            return node1;
        } else {
            node2.next = merge(node2.next, node1);
            node2.next.prev = node2;
            node2.prev = null;
            return node2;
        }
    }

    static Node mergeSort(Node head) {
        if (head.next == null || head == null)
            return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter length of DLL: ");
        int n = sc.nextInt();

        System.out.print("Enter elements of DLL: ");
        Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }

        sc.close();

        System.out.print("List before sorting: ");
        printDLL(head);

        head = mergeSort(head);

        System.out.print("List after sorting: ");
        printDLL(head);

    }
}