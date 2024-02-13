import java.util.Scanner;
import java.util.Stack;

class minStack {
    Stack<Integer> s;
    Stack<Integer> minElements;

    minStack() {
        s = new Stack<>();
        minElements = new Stack<>();
    }

    void push(int num) {
        s.push(num);
        if (minElements.empty())
            minElements.push(num);
        else if (num <= minElements.peek())
            minElements.push(num);
    }

    int pop() {
        if (s.empty())
            return -1;

        int num;
        num = s.pop();
        if (num == minElements.peek())
            minElements.pop();
        return num;
    }

    int peek() {
        if (s.empty())
            return -1;
        return s.peek();
    }

    int getMin() {
        if (minElements.empty())
            return -1;
        return minElements.peek();
    }
}

public class minStackImplementation {
    public static void main(String[] args) {
        minStack myStack = new minStack();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. PUSH, 2. POP, 3. PEEK, 4. GETMIN, 5. EXIT");
        System.out.println("Enter operation you wish to perform: ");

        int operation = sc.nextInt();
        int temp;
        do {
            switch (operation) {
                case 1:
                    temp = sc.nextInt();
                    myStack.push(temp);
                    System.out.println("Pushed element " + temp);
                    break;

                case 2:
                    temp = myStack.pop();
                    if (temp == -1)
                        System.out.println("Stack is empty, cannot pop");
                    else
                        System.out.println("Popped element " + temp);
                    break;

                case 3:
                    temp = myStack.peek();
                    if (temp == -1)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Peeked element " + temp);
                    break;

                case 4:
                    temp = myStack.getMin();
                    if (temp == -1)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Min element " + temp);
                    break;

                default:
                    break;
            }
            operation = sc.nextInt();
        } while (operation != 5);

        sc.close();
    }
}