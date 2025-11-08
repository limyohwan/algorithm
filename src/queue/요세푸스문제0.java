package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        List<Integer> polledList = new ArrayList<>();

        int order = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (order % k == 0) {
                polledList.add(poll);
            } else {
                queue.offer(poll);
            }
            order++;
        }

        String result = polledList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("<" + result + ">");
    }
}
