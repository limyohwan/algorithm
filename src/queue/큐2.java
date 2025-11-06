package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] command = line.split(" ");

            if (command[0].equals("push")) {
                queue.offer(Integer.valueOf(command[1]));
            } else if (command[0].equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if (command[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command[0].equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command[0].equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (command[0].equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
