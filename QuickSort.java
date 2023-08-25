import java.util.Scanner;
import java.util.Random;
public class Quicksort {
    public static void main(String[] args) {
        int n,ch;
        long start, end, time;
        QSort obj = new QSort();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        n = sc.nextInt();
        System.out.println("Enter the choice (0 for ascending, 1 for descending, any other value for random): ");
        ch = sc.nextInt();
        obj.create(n, ch);
        System.out.println("The array is: ");
        obj.print_array();
        start = System.nanoTime();
        obj.sort(0, n - 1);
        end = System.nanoTime();
        System.out.println("The sorted array is: ");
        obj.print_array();
        time = (end - start);
        System.out.println("Time for sorting is: "+ time +"ns");
    }
}
class QSort {
    int n;
    int arr[];

    public void create(int n, int choice) {
        this.n = n;
        arr = new int[n + 1];
        if (choice == 0) {
            for (int i = 0; i < n; i++)
                arr[i] = i;
        } else if (choice == 1) {
            for (int i = 0; i < n; i++)
                arr[i] = n - i;
        } else {
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(10000000);
            }
        }
        arr[n] = 9999999;
    }

    public void sort(int low, int high) {
        int s;
        if (low < high) {
            s = partition(arr, low, high);
            sort(low, s - 1);
            sort(s + 1, high);
        }
    }

    private int partition(int arr[], int low, int high) {
        int pivot, i, j;
        pivot = arr[low];
        i = low;
        j = high;
        while (i <= j) {
            while (arr[j] > pivot)
                j--;
            while (arr[i] <= pivot)
                i++;
            swap(arr, i, j);
        }
        swap(arr, i, j);
        swap(arr, low, j);
        return j;
    }

    private void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print_array() {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
