package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            switch (X) {
                case 1: {
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                }
                case 2: {
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                }
                case 3: {
                    sb.append(stack.size()).append("\n");
                    break;
                }
                case 4: {
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else{
                        sb.append("0\n");
                    }
                    break;
                }
                case 5: {
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                }
                default: break;
            }
        }

        System.out.println(sb);
    }
}
