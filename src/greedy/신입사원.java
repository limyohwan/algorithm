package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            List<Rank> ranks = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Rank rank = new Rank();
                rank.resumeRank = Integer.parseInt(st.nextToken());
                rank.interviewRank = Integer.parseInt(st.nextToken());
                ranks.add(rank);
            }

            ranks.sort(Comparator.comparingInt(o -> o.interviewRank));

            int max = N;
            int answer = 0;
            for (Rank rank : ranks) {
                if (max >= rank.resumeRank) {
                    max = rank.resumeRank;
                    answer++;
                }
            }

            System.out.println(answer);
        }

    }

    static class Rank {
        int resumeRank;
        int interviewRank;
    }
}
