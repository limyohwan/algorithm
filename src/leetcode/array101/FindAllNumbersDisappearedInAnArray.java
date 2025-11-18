package leetcode.array101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] checked = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            checked[nums[i]] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < nums.length + 1; i++) {
            if (!checked[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> present = new HashSet<>();

        // 배열에 존재하는 숫자들을 Set에 추가
        for (int num : nums) {
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();

        // 1부터 n까지 확인
        for (int i = 1; i <= nums.length; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        // 각 숫자를 인덱스로 사용하여 해당 위치를 음수로 표시
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 인덱스는 0부터 시작

            // 아직 양수라면 음수로 변경 (중복 방지)
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<>();

        // 양수로 남아있는 인덱스 + 1이 사라진 숫자
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        // 원본 배열 복원 (필요시)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers4(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            // 이진 탐색으로 존재 여부 확인
            if (Arrays.binarySearch(nums, i) < 0) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers5(int[] nums) {
        int n = nums.length;

        // 각 숫자를 자신의 위치로 이동
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= n) {
                int correctPos = nums[i] - 1;
                if (nums[correctPos] == nums[i]) break; // 중복 방지

                // 스왑
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();

        // 자신의 위치에 없는 인덱스 찾기
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
