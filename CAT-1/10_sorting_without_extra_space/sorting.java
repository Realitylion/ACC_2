import java.util.Arrays;
import java.util.Scanner;

public class sorting {

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int cur = low - 1, temp;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                cur++;
                temp = arr[i];
                arr[i] = arr[cur];
                arr[cur] = temp;
            }
        }

        temp = arr[cur + 1];
        arr[cur + 1] = arr[high];
        arr[high] = temp;
        return cur + 1;

    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static void merge(int arr[], int low, int high, int mid) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];
        for (int i = 0; i < n2; i++)
            right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of elements in the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter 1 for quickSort, 2 for mergeSort: ");
        int choice = sc.nextInt();

        sc.close();

        if (choice == 1)
            quickSort(arr, 0, n - 1);
        else
            mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array is: " + Arrays.toString(arr));
    }
}