import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 3,2,5,4,1 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr) {
        for(int i =0; i < arr.length; i++){
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr,0,last); //2
            swap(arr,maxIndex,last);
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for(int j = start; j <= last; j++){
            if(arr[max]<arr[j]){
                max = j;
            }
        }
        return max;
    }
}
