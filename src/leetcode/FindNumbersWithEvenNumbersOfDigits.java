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

    public int findNumbers2(int[] nums) {
        int evenDigitCount = 0;

        for (int number : nums) {
            if (String.valueOf(number).length() % 2 == 0) {
                evenDigitCount++;
            }
        }

        return evenDigitCount;
    }

    public int findNumbers3(int[] nums) {
        int even = 0;

        for (int num : nums) {
            int digits = getDigits(num);
            if (digits % 2 == 0) {
                even++;
            }
        }

        return even;
    }

    private int getDigits(int n) {
        if (n == 0) return 1;
        return (int) Math.log10(n) + 1;
    }

    public int findNumbers4(int[] nums) {
        int counter = 0;

        for (int num : nums) {
            int digits = 0;

            if (num == 0) {
                digits = 1;
            }

            while (num > 0) {
                num = num / 10;
                digits++;
            }

            // 비트 AND 연산으로 짝수 판별
            if ((digits & 1) == 0) {
                counter++;
            }
        }

        return counter;
    }

}
