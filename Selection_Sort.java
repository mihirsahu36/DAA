import java.util.Scanner;
import java.util.Random;

public class selsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, ch;
        long time, start, end;
        sort obj = new sort();
        System.out.println("Enter the number: ");
        n = sc.nextInt();
        System.out.println("Enter the choice (0 for ascending, 1 for descending, any other value for random): ");
        ch = sc.nextInt();
        obj.create_arr(n, ch);
        System.out.println("The array is: ");
        obj.print_arr();
        start = System.nanoTime();
        obj.sorting();
        end = System.nanoTime();
        System.out.println("The sorted array is: ");
        obj.print_arr();
        time = end - start;
        System.out.println("Time for sorting is: " + time + "ns");
    }
}

class sort {
    int n;
    int arr[];

    public void create_arr(int n, int ch) {
        this.n = n;
        arr = new int[n];
        if (ch == 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        } else if (ch == 1) {
            for (int i = 0; i < n; i++) {
                arr[i] = n - i;
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(10000000);
            }
        }
    }

    public void sorting() {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print_arr() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
