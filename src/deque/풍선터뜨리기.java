package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] balloons = br.readLine().split(" ");

        Deque<Balloon> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.add(new Balloon(i + 1, Integer.parseInt(balloons[i])));
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Balloon current = deque.removeFirst();
            sb.append(current.index).append("\n");

            if (deque.isEmpty()) break;

            int move = current.move;
            if (move > 0) {
                for (int i = 0; i < (move - 1) % deque.size(); i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move) % deque.size(); i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int move;

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }
}