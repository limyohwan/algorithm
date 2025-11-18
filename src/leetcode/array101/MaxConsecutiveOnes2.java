package leetcode.array101;

public class MaxConsecutiveOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longestSequence = 0;

        for (int left = 0; left < nums.length; left++) {
            int numZeroes = 0;

            // 모든 연속 구간 확인
            for (int right = left; right < nums.length; right++) {
                if (nums[right] == 0) {
                    numZeroes++;
                }

                // 0이 1개 이하면 유효한 구간
                if (numZeroes <= 1) {
                    longestSequence = Math.max(longestSequence, right - left + 1);
                } else {
                    break; // 0이 2개 이상이면 종료
                }
            }
        }

        return longestSequence;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int longestSequence = 0;
        int left = 0;
        int numZeroes = 0;

        for (int right = 0; right < nums.length; right++) {
            // 윈도우 확장: 0을 만나면 카운트 증가
            if (nums[right] == 0) {
                numZeroes++;
            }

            // 0이 2개가 되면 윈도우 축소
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // 최대 길이 갱신
            longestSequence = Math.max(longestSequence, right - left + 1);
        }

        return longestSequence;
    }

    public int findMaxConsecutiveOnes3(int[] nums) {
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // 0을 만나면 카운트 증가
            if (nums[right] == 0) {
                zeroCount++;
            }

            // 0이 2개 이상이면 윈도우를 슬라이드 (크기 유지)
            if (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }

        // 최종 윈도우 크기가 최대 길이
        return nums.length - left;
    }

}
