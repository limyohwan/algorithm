package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "-");

        int answer = 0;
        boolean isFirst = true;
        while (st.hasMoreElements()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            int sum = 0;
            while (st2.hasMoreElements()) {
                sum += Integer.parseInt(st2.nextToken());
            }
            if (isFirst) {
                answer += sum;
                isFirst = false;
            } else{
                answer -= sum;
            }
        }

        System.out.println(answer);
    }
}
