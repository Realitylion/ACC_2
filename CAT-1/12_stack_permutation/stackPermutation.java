import java.util.Scanner;
import java.util.Stack;

public class stackPermutation {
    static boolean isStackPermutation(int arr1[], int arr2[], int n) {
        Stack<Integer> s = new Stack<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            s.push(arr1[i]);
            while (!s.empty() && s.peek() == arr2[cur]) {
                s.pop();
                cur++;
            }
        }

        return s.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int targetArr[] = new int[n];
        System.out.println("Enter target array elements");
        for (int i = 0; i < n; i++)
            targetArr[i] = sc.nextInt();

        sc.close();

        if (isStackPermutation(arr, targetArr, n))
            System.out.println("It is a stack permutation");
        else
            System.out.println("It is not a stack permutation");
    }
}