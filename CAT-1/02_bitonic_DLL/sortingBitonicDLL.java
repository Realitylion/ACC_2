import java.util.Scanner;

class Node {
    int num;
    Node next;
    Node prev;

    Node(int val) {
        num = val;
        next = null;
        prev = null;
    }
}

public class sortingBitonicDLL {

    static Node insertNode(int val, Node head) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    static Node sortBitonicDLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node first = head;
        Node last = head;
        while (last.next != null)
            last = last.next;

        Node newHead = null;

        while (first.next != last) {
            if (first.num < last.num) {
                newHead = insertNode(first.num, newHead);
                first = first.next;
            } else {
                newHead = insertNode(last.num, newHead);
                last = last.prev;
            }
        }

        if (first.num < last.num) {
            newHead = insertNode(first.num, newHead);
            newHead = insertNode(last.num, newHead);
        } else {
            newHead = insertNode(last.num, newHead);
            newHead = insertNode(first.num, newHead);
        }

        return newHead;
    }

    static void printBitonicDLL(Node head) {
        if (head == null)
            return;
        while (head.next != null) {
            System.out.print(head.num + " ");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter values for DLL: ");

        Node head = null;
        for (int i = 0; i < n; i++)
            head = insertNode(sc.nextInt(), head);

        sc.close();

        System.out.print("DLL before sorting: ");
        printBitonicDLL(head);

        // sorting
        head = sortBitonicDLL(head);

        System.out.print("DLL after sorting: ");
        printBitonicDLL(head);
    }
}