//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    int target = 7;
    int[] ans = twoSum(arr, target);
        System.out.print("[");
        for (int i = 0; i < ans.length ; i++) {
            System.out.print(ans[i]+ ",");
        }
        System.out.println("]");

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }

            }

        }
        return result;
    }

}