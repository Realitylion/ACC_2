import java.util.Scanner;

class Node {
    int val;
    Node next;

    public Node(int num) {
        val = num;
        next = null;
    }
}

public class segregateLinkedList {
    static Node insertNode(Node head, int num) {
        Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;

        return head;
    }

    static void printLinkedList(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    static Node segregate(Node head, int n) {
        if (head == null || head.next == null)
            return head;

        Node end = head;
        while (end.next != null)
            end = end.next;

        Node itr = head;
        Node prev = null;
        Node newHead = head;
        for (int i = 0; i < n; i++) {

            if (itr.val % 2 == 0) {
                prev = itr;
                itr = itr.next;
                continue;
            }

            if (prev == null) {
                end.next = itr;
                end = end.next;
                newHead = itr.next;
                itr.next = null;
                itr = newHead;
                continue;
            }

            end.next = itr;
            end = end.next;
            prev.next = itr.next;
            itr.next = null;
            itr = prev.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of elements in linked list:");
        int n = sc.nextInt();
        Node head = null;
        System.out.print("Enter values: ");
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }

        sc.close();

        System.out.print("Linked list before segregating: ");
        printLinkedList(head);

        head = segregate(head, n);

        System.out.print("Linked list after segregating: ");
        printLinkedList(head);
    }
}