package leetcode;

public class FindNumbersWithEvenNumbersOfDigits {
    public static void main(String[] args) {
        System.out.println(isEven(1234));
    }
    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (isEven(num)) {
                result++;
            }
        }
        return result;
    }

    public static boolean isEven(int num) {
        int count = 1;
        while (num / 10 > 0) {
            num /= 10;
            count++;
        }

        return count % 2 == 0;
    }
}
