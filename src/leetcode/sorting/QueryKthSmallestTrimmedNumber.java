package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class QueryKthSmallestTrimmedNumber {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            String[][] trimAndIndex = new String[nums.length][2];
            for (int j = 0; j < nums.length; j++) {
                trimAndIndex[j][0] = nums[j].substring(nums[j].length() - trim);
                trimAndIndex[j][1] = String.valueOf(j);
            }

            Arrays.sort(trimAndIndex, (a, b) -> {
                int cmp = a[0].compareTo(b[0]);
                if (cmp == 0) {
                    return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
                }
                return cmp;
            });

            result[i] = Integer.parseInt(trimAndIndex[k - 1][1]);
        }

        return result;
    }

    public int[] smallestTrimmedNumbers2(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            // List<Pair<트리밍된값, 인덱스>> 생성
            List<Pair<String, Integer>> pairs = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                String trimmed = nums[j].substring(nums[j].length() - trim);
                pairs.add(new Pair<>(trimmed, j));
            }

            // 정렬 (첫 번째 요소 우선, 같으면 두 번째 요소)
            pairs.sort((a, b) -> {
                int cmp = a.getKey().compareTo(b.getKey());
                return cmp != 0 ? cmp : a.getValue() - b.getValue();
            });

            result[i] = pairs.get(k - 1).getValue();
        }

        return result;
    }

    // Pair 클래스 정의
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    public int[] smallestTrimmedNumbers3(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            // Max Heap (k개만 유지)
            PriorityQueue<Pair<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
                int cmp = b.getKey().compareTo(a.getKey());
                return cmp != 0 ? cmp : b.getValue() - a.getValue();
            });

            for (int j = 0; j < nums.length; j++) {
                String trimmed = nums[j].substring(nums[j].length() - trim);
                maxHeap.offer(new Pair<>(trimmed, j));

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            result[i] = maxHeap.peek().getValue();
        }

        return result;
    }

    public int[] smallestTrimmedNumbers4(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        // trim 길이별로 정렬 결과를 캐싱
        Map<Integer, List<Pair<String, Integer>>> cache = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            // 캐시에 없으면 계산
            if (!cache.containsKey(trim)) {
                List<Pair<String, Integer>> pairs = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    String trimmed = nums[j].substring(nums[j].length() - trim);
                    pairs.add(new Pair<>(trimmed, j));
                }
                pairs.sort((a, b) -> {
                    int cmp = a.getKey().compareTo(b.getKey());
                    return cmp != 0 ? cmp : a.getValue() - b.getValue();
                });
                cache.put(trim, pairs);
            }

            // 캐시에서 결과 가져오기
            result[i] = cache.get(trim).get(k - 1).getValue();
        }

        return result;
    }

    public int[] smallestTrimmedNumbers5(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int maxLen = nums[0].length();

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            // Radix Sort 적용
            Integer[] indices = new Integer[nums.length];
            for (int j = 0; j < nums.length; j++) {
                indices[j] = j;
            }

            // LSD (Least Significant Digit) Radix Sort
            for (int pos = maxLen - 1; pos >= maxLen - trim; pos--) {
                indices = countingSort(nums, indices, pos);
            }

            result[i] = indices[k - 1];
        }

        return result;
    }

    private Integer[] countingSort(String[] nums, Integer[] indices, int pos) {
        int[] count = new int[10];

        // 빈도 계산
        for (int idx : indices) {
            int digit = nums[idx].charAt(pos) - '0';
            count[digit]++;
        }

        // 누적 합
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 정렬된 결과 생성
        Integer[] output = new Integer[indices.length];
        for (int i = indices.length - 1; i >= 0; i--) {
            int idx = indices[i];
            int digit = nums[idx].charAt(pos) - '0';
            output[count[digit] - 1] = idx;
            count[digit]--;
        }

        return output;
    }
}
