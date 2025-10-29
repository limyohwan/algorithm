package polygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 대지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (i == 0) {
                maxX = x;
                minX = x;
                maxY = y;
                minY = y;
            } else {
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
