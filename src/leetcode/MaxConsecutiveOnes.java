package leetcode;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }

        max = Math.max(max, count);

        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int max = 0;

        for (int n : nums) {
            if (n == 1) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }

        return max;
    }

    public int findMaxConsecutiveOnes3(int[] nums) {
        int maxConsecutive = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxConsecutive = Math.max(maxConsecutive, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxConsecutive;
    }

    public int findMaxConsecutiveOnes4(int[] nums) {
        int count = 0, max = 0;

        for (int n : nums) {
            max = Math.max(max, count = n == 0 ? 0 : count + 1);
        }

        return max;
    }
}
