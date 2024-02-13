import java.util.Scanner;

class Node {
	int num;
	Node next;

	Node(int val) {
		num = val;
		next = null;
	}
}

class loopDetection {
	static Node insertNode(Node head, int val) {
		Node newNode = new Node(val);

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

	static void display(Node head) {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.num + "->");
			temp = temp.next;
		}
		System.out.println(temp.num);
	}

	static void createLoop(Node head, int a, int b) {
		Node temp1 = head, temp2 = head;
		int cnt;

		for (cnt = 0; cnt < a - 1; cnt++)
			temp1 = temp1.next;
		for (cnt = 0; cnt < b - 1; cnt++)
			temp2 = temp2.next;

		temp2.next = temp1;
	}

	static boolean detectLoop(Node head) {
		if (head == null)
			return false;

		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node head = null;

		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			head = insertNode(head, val);
		}

		display(head);

		// int a = sc.nextInt();

		sc.close();

		// createLoop(head, a, n);

		if (detectLoop(head) == true)
			System.out.println("Loop detected");
		else
			System.out.println("Loop not detected");
	}
}