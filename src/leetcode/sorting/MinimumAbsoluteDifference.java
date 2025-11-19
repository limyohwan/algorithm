package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minimum = Integer.MAX_VALUE;
        int[] diff = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
            minimum = Math.min(minimum, diff[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] == minimum) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        // 1. 배열 정렬
        Arrays.sort(arr);

        // 2. 최소 차이 찾기
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        // 3. 최소 차이를 가진 모든 쌍 수집
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifference3(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            // 더 작은 차이를 발견하면 결과 초기화
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(List.of(arr[i], arr[i + 1]));
            }
            // 같은 차이를 발견하면 결과에 추가
            else if (diff == minDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifference4(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // TreeMap에 저장 (자동 정렬)
        for (int num : arr) {
            map.put(num, 1);
        }

        List<Integer> sortedList = new ArrayList<>(map.keySet());
        int minDiff = Integer.MAX_VALUE;

        // 최소 차이 찾기
        for (int i = 0; i < sortedList.size() - 1; i++) {
            minDiff = Math.min(minDiff, sortedList.get(i + 1) - sortedList.get(i));
        }

        // 결과 수집
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            if (sortedList.get(i + 1) - sortedList.get(i) == minDiff) {
                result.add(List.of(sortedList.get(i), sortedList.get(i + 1)));
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifference5(int[] arr) {
        Arrays.sort(arr);

        // 최소 차이 계산
        int minDiff = IntStream.range(0, arr.length - 1)
                .map(i -> arr[i + 1] - arr[i])
                .min()
                .orElse(Integer.MAX_VALUE);

        // 결과 수집
        return IntStream.range(0, arr.length - 1)
                .filter(i -> arr[i + 1] - arr[i] == minDiff)
                .mapToObj(i -> List.of(arr[i], arr[i + 1]))
                .collect(Collectors.toList());
    }
}
