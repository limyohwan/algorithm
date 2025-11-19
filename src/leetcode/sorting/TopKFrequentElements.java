package leetcode.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());


        int[] result = new int[k];
        int index = 0;

        for (int i = collect.size() - 1; i > collect.size() - k - 1; i--) {
            result[index] = collect.get(i).getKey();
            index += 1;
        }

        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도 기준 정렬
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // 3. 상위 k개 추출
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap (빈도 기준)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // 가장 낮은 빈도 제거
            }
        }

        // 3. 결과 추출
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public int[] topKFrequent4(int[] nums, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 버킷 생성 (index = 빈도, value = 해당 빈도를 가진 원소들)
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            buckets[freq].add(entry.getKey());
        }

        // 3. 높은 빈도부터 k개 수집
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets[i].isEmpty()) {
                result.addAll(buckets[i]);
            }
        }

        return result.stream().limit(k).mapToInt(i -> i).toArray();
    }

    public int[] topKFrequent5(int[] nums, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 고유 원소 배열 생성
        int[] unique = freqMap.keySet().stream().mapToInt(i -> i).toArray();
        int n = unique.length;

        // 3. QuickSelect로 상위 k개 찾기
        quickSelect(unique, 0, n - 1, n - k, freqMap);

        // 4. 마지막 k개 원소 반환
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickSelect(int[] nums, int left, int right, int k,
                             Map<Integer, Integer> freqMap) {
        if (left >= right) return;

        // 랜덤 피벗 선택
        int pivotIdx = left + new Random().nextInt(right - left + 1);
        pivotIdx = partition(nums, left, right, pivotIdx, freqMap);

        if (pivotIdx == k) return;
        else if (pivotIdx > k) {
            quickSelect(nums, left, pivotIdx - 1, k, freqMap);
        } else {
            quickSelect(nums, pivotIdx + 1, right, k, freqMap);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIdx,
                          Map<Integer, Integer> freqMap) {
        int pivotFreq = freqMap.get(nums[pivotIdx]);
        swap(nums, pivotIdx, right);

        int storeIdx = left;
        for (int i = left; i < right; i++) {
            if (freqMap.get(nums[i]) < pivotFreq) {
                swap(nums, i, storeIdx);
                storeIdx++;
            }
        }

        swap(nums, storeIdx, right);
        return storeIdx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] topKFrequent6(int[] nums, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. TreeMap으로 빈도별 그룹화 (빈도 역순)
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            treeMap.putIfAbsent(freq, new ArrayList<>());
            treeMap.get(freq).add(entry.getKey());
        }

        // 3. 상위 k개 수집
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : treeMap.values()) {
            result.addAll(list);
            if (result.size() >= k) break;
        }

        return result.stream().limit(k).mapToInt(i -> i).toArray();
    }

    public int[] topKFrequent7(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
