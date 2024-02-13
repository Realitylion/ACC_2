import java.util.Arrays;
import java.util.Scanner;

public class maxSlidingWindow {

    // naive approach

    static int[] slidingWindow(int arr[], int n, int m) {
        int[] maxValues = new int[n - m + 1];

        for (int i = 0; i < n - m + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + m; j++)
                max = (arr[j] > max) ? arr[j] : max;
            maxValues[i] = max;
        }

        return maxValues;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter size of sliding window: ");
        int m = sc.nextInt();

        sc.close();

        int maxValues[] = slidingWindow(arr, n, m);
        System.out.println("Maximum values are: " + Arrays.toString(maxValues));
    }
}