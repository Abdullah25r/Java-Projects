public class IntSearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        boolean ans = search(arr,target);
        System.out.println(ans);
    }
    public static boolean search(int[] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }

}