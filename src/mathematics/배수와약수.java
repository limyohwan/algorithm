package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        while(!str.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 % num2 == 0) {
                System.out.println("multiple");
            } else if (num2 % num1 == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }

            str = br.readLine();
        }

    }
}
