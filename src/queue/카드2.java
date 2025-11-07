package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        int last = 0;
        boolean remove = true;
        while (!queue.isEmpty()) {
            if (remove) {
                last = queue.poll();
                remove = false;
            } else {
                int poll = queue.poll();
                queue.offer(poll);
                remove = true;
            }
        }

        System.out.println(last);
    }
}
