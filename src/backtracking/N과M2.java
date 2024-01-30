package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        backtracking(1, N, M, "", visited);
    }

    private static void backtracking(int at, int N, int M, String str, boolean[] visited) {
        if(M == 0) {
            System.out.println(str);
            return;
        }

        for (int i = at; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(i + 1, N, M-1, str + i + " ", visited);
            visited[i] = false;
        }
    }
}
