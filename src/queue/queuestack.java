package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] c = br.readLine().split(" ");

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (a[i].equals("0")) {
                deque.addLast(Integer.valueOf(b[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String number = c[i];
            deque.addFirst(Integer.valueOf(number));
            sb.append(deque.removeLast()).append(" ");
        }

        System.out.println(sb);
    }
}
