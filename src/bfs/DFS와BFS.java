package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i = 1; i <= M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        boolean[] visited = new boolean[N+1];
        dfs(V, N, visited);

        System.out.println();

        boolean[] visited2 = new boolean[N+1];
        bfs(V, N, visited2);
    }

    public static void dfs(int V, int N, boolean[] visited) {
        System.out.print(V + " ");
        visited[V] = true;
        for (int i = 1; i <= N; i++ ) {
            if (graph[V][i] == 0 || visited[i]) {
                continue;
            }
            dfs(i, N, visited);
        }
    }

    public static void bfs(int V, int N, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= N; i++) {
                if (visited[i] || graph[v][i] == 0) {
                    continue;
                }
                queue.offer(i);
                visited[i] = true;
            }
        }
    }

}
