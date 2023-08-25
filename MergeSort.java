import java.util.Scanner;

public class mergesort1 {
    public static void divide(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        conquer(arr, low, mid, high);
    }

    public static void conquer(int arr[], int low, int mid, int high) {
        int merge[] = new int[high - low + 1];
        int x = 0, idx1 = low, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1] <= arr[idx2]) {
                merge[x++] = arr[idx1++];
            } else {
                merge[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merge[x++] = arr[idx1++];
        }

        while (idx2 <= high) {
            merge[x++] = arr[idx2++];
        }

        for (int i = 0; i < merge.length; i++) {
            arr[i + low] = merge[i]; // Corrected indexing to consider the starting position 'low'
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        divide(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
