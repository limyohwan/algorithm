package leetcode.array101;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];

        int evenIndex = 0;
        int oddIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                answer[evenIndex] = nums[i];
                evenIndex++;
            } else {
                answer[oddIndex] = nums[i];
                oddIndex--;
            }
        }

        return answer;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}
