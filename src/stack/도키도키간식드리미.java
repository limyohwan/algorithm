package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();
        for (String s : input) {
            queue.offer(Integer.parseInt(s));
        }

        Stack<Integer> waitingLine = new Stack<>();
        int orderNumber = 1;

        while (!queue.isEmpty()) {
            while (!waitingLine.isEmpty() && waitingLine.peek() == orderNumber) {
                waitingLine.pop();
                orderNumber++;
            }

            Integer current = queue.poll();
            if (orderNumber == current) {
                orderNumber++;
            } else {
                waitingLine.push(current);
            }
        }

        while (!waitingLine.isEmpty() && waitingLine.peek() == orderNumber) {
            waitingLine.pop();
            orderNumber++;
        }

        System.out.println(waitingLine.isEmpty() ? "Nice" : "Sad");
    }
}
