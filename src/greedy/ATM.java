package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] waitingTime = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            waitingTime[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waitingTime);

        int[] realWaitingTime = new int[N];
        realWaitingTime[0] = waitingTime[0];
        for (int i = 1; i < N; i++) {
            realWaitingTime[i] = realWaitingTime[i - 1] + waitingTime[i];
        }

        System.out.println(Arrays.stream(realWaitingTime).sum());
    }
}
