package leetcode.beginner;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        runningSum(nums);
    }

    public static int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        return sums;
    }

    public static int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i -1];
        }

        return nums;
    }
}
