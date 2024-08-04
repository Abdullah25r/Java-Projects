import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = { 3,2,5,4,1 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cycleSort(int[] arr) {
        
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
