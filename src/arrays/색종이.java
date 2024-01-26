package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] papers = new int[101][101];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            for (int x = num1; x < num1 + 10; x++) {
                for (int y = num2; y < num2 + 10; y++) {
                    papers[x][y] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < papers.length; i++) {
            for (int j = 0; j < papers[i].length; j++) {
                answer += papers[i][j];
            }
        }

        System.out.println(answer);
    }
}
