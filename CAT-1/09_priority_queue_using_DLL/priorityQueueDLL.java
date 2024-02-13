import java.util.Scanner;

class Node {
    int data;
    int priority;
    Node next;
    Node prev;

    Node(int num, int p) {
        data = num;
        priority = p;
        next = null;
        prev = null;
    }
}

public class priorityQueueDLL {
    static Node insert(Node head, int data, int priority) {
        Node newNode = new Node(data, priority);
        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (newNode.priority >= temp.priority && temp.next != null)
            temp = temp.next;

        // add new node at end of DLL
        if (temp.next == null && newNode.priority >= temp.priority) {
            temp.next = newNode;
            newNode.prev = temp;
        } else {
            // add new node at start of DLL
            if (temp.prev == null) {
                newNode.next = temp;
                temp.prev = newNode;
                head = newNode;
            }
            // add new node in the middle of DLL
            else {
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev = newNode;
            }
        }

        return head;
    }

    static Node delete(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head.next;
        temp.prev = null;
        head = head.next;

        return head;
    }

    static int peek(Node head) {
        if (head == null)
            return -1;
        return head.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.println("\n1. INSERT, 2. DELETE, 3. PEEK, 4. EXIT");
        System.out.println("Enter which operation you would like to perform: ");

        int operation = sc.nextInt(), data, priority;
        do {
            switch (operation) {
                case 1:
                    System.out.println("Enter data and priority of data to insert: ");
                    data = sc.nextInt();
                    priority = sc.nextInt();
                    head = insert(head, data, priority);
                    System.out.println("Inserted " + data + " at priority " + priority);
                    break;

                case 2:
                    if (head == null) {
                        System.out.println("Priority queue is empty, cannot delete");
                        break;
                    }

                    head = delete(head);
                    System.out.println("Deleted first element in priority queue");
                    break;

                case 3:
                    int val = peek(head);
                    if (val == -1)
                        System.out.println("Priority queue is empty");
                    else
                        System.out.println("First element in priority queue: " + val);
                    break;

                default:
                    break;
            }
            System.out.println("\n1. INSERT, 2. DELETE, 3. PEEK, 4. EXIT");
            System.out.println("Enter which operation you would like to perform: ");
            operation = sc.nextInt();
        } while (operation != 4);

        sc.close();
    }
}