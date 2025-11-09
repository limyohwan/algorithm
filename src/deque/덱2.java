package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] command = line.split(" ");

            if (command[0].equals("1")) {
                deque.addFirst(command[1]);
            } else if (command[0].equals("2")) {
                deque.addLast(command[1]);
            } else if (command[0].equals("3")) {
                sb.append(!deque.isEmpty() ? deque.pollFirst(): -1).append("\n");
            } else if (command[0].equals("4")) {
                sb.append(!deque.isEmpty() ? deque.pollLast() : -1).append("\n");
            } else if (command[0].equals("5")) {
                sb.append(deque.size()).append("\n");
            } else if (command[0].equals("6")) {
                sb.append(!deque.isEmpty() ? 0 : 1).append("\n");
            } else if (command[0].equals("7")) {
                sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
            } else if (command[0].equals("8")) {
                sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
