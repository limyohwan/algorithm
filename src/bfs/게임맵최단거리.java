package bfs;

import java.util.*;

// 미로탐색과 같음
public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int answer = -1;

        boolean[][] visited = new boolean[100][100];
        Queue<Integer> yQueue =new LinkedList<>();
        yQueue.offer(0);
        Queue<Integer> xQueue =new LinkedList<>();
        xQueue.offer(0);
        Queue<Integer> countQueue =new LinkedList<>();
        countQueue.offer(1);

        int N = maps.length;
        int M = maps[0].length;

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
            if(canMove(x, y - 1, M, N, visited, maps)) {
                yQueue.offer(y - 1);
                xQueue.offer(x);
                countQueue.offer(count + 1);
            }

            // 하
            if(canMove(x, y + 1, M, N, visited, maps)) {
                yQueue.offer(y + 1);
                xQueue.offer(x);
                countQueue.offer(count + 1);
            }
            // 좌
            if(canMove(x - 1, y, M, N, visited, maps)) {
                yQueue.offer(y);
                xQueue.offer(x - 1);
                countQueue.offer(count + 1);
            }
            // 우
            if(canMove(x + 1, y, M, N, visited, maps)) {
                yQueue.offer(y);
                xQueue.offer(x + 1);
                countQueue.offer(count + 1);
            }

        }

        return answer;
    }

    private static boolean canMove(int x, int y, int M, int N, boolean[][] visited, int[][] maps) {
        if(x > M - 1 || x < 0 || y > N - 1 || y < 0) {
            return false;
        }

        if (maps[y][x] == 0) {
            return false;
        }

        if (visited[y][x]) {
            return false;
        }

        return true;
    }
}
