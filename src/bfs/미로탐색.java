package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    // BFS
    // 최단 거리, 큐를 사용하기 때문에 스택오버플로에서 비교적 자유로움
    static int[][] maze  = new int[100][100];
    static boolean[][] visited = new boolean[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int y = 0; y < N; y++) {
            char[] charArray = br.readLine().toCharArray();
            for(int x = 0; x < M; x++) {
                maze[y][x] = Character.getNumericValue(charArray[x]);
            }
        }

        Queue<Integer> yQueue =new LinkedList<>();
        yQueue.offer(0);
        Queue<Integer> xQueue =new LinkedList<>();
        xQueue.offer(0);
        Queue<Integer> countQueue =new LinkedList<>();
        countQueue.offer(1);

        int answer = 0;
        while (!yQueue.isEmpty()) {
            int y = yQueue.poll();
            int x = xQueue.poll();
            int count = countQueue.poll();

            if (visited[y][x]) {
                continue;
            }
            visited[y][x] = true;

            if ( y == N - 1 && x == M - 1) {
                answer = count;
                break;
            }

            // 상
            if(canMove(x, y - 1, M, N)) {
                yQueue.offer(y - 1);
                xQueue.offer(x);
                countQueue.offer(count + 1);
            }

            // 하
            if(canMove(x, y + 1, M, N)) {
                yQueue.offer(y + 1);
                xQueue.offer(x);
                countQueue.offer(count + 1);
            }
            // 좌
            if(canMove(x - 1, y, M, N)) {
                yQueue.offer(y);
                xQueue.offer(x - 1);
                countQueue.offer(count + 1);
            }
            // 우
            if(canMove(x + 1, y, M, N)) {
                yQueue.offer(y);
                xQueue.offer(x + 1);
                countQueue.offer(count + 1);
            }

        }

        System.out.println(answer);
    }

    private static boolean canMove(int x, int y, int M, int N) {
        if(x > M - 1 || x < 0 || y > N - 1 || y < 0) {
            return false;
        }

        if (maze[y][x] == 0) {
            return false;
        }

        if (visited[y][x]) {
            return false;
        }

        return true;
    }
}
