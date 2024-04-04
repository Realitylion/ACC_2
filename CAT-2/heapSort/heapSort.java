import java.util.Scanner;

class heapSort {
    static void heapify(int[] arr, int n) {
        int tmp;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int leftChild = (i + 1) * 2 - 1;
            int rightChild = (i + 1) * 2;
            if (rightChild < n && arr[rightChild] < arr[i]) {
                tmp = arr[rightChild];
                arr[rightChild] = arr[i];
                arr[i] = tmp;
            }
            if (arr[leftChild] < arr[i]) {
                tmp = arr[leftChild];
                arr[leftChild] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    static int[] sort(int[] arr) {
        int len = arr.length;
        heapify(arr, len);
        int[] sortedArr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[0];
            arr[0] = arr[len - 1];
            len--;
            heapify(arr, len);
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        int[] sortedArr = sort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(sortedArr[i] + " ");
    }
}