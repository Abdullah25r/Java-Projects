import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = { 3,2,5,4,1 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cycleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
            
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
