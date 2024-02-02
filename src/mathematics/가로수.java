package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lights = new int[N];

        for (int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(br.readLine());
        }

        int[] intervals = new int[N - 1];
        for (int i = 1; i < N; i++) {
            intervals[i - 1] = lights[i] - lights[i - 1];
        }

        int gcd = intervals[0];
        for (int i = 1; i< intervals.length; i++) {
            gcd = gcd(gcd, intervals[i]);
        }

        int answer = 0;
        for (int interval : intervals) {
            answer += interval / gcd - 1;
        }

        System.out.println(answer);
    }

    static int gcd(int a, int b) {
        while(b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }

    static int gcd2(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd2(b, a % b);
        }
    }
}
