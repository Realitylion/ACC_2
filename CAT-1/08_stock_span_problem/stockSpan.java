import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    static int[] calculateSpans(int[] stockPrices, int n) {
        int span[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stockPrices[i] >= stockPrices[stack.peek()]) {
                stack.pop();
            }
            // if stack is empty, it means cur day's stock is the highest so far
            // if stack is not empty, then all values from top of stack to cur day are
            // less than or equal to cur day stock
            span[i] = stack.empty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int stockPrices[] = new int[n];
        System.out.print("Enter price of stocks on each day: ");
        for (int i = 0; i < n; i++)
            stockPrices[i] = sc.nextInt();

        sc.close();

        int spans[] = calculateSpans(stockPrices, n);
        System.out.println("Span values are: " + Arrays.toString(spans));
    }
}