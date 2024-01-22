package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> workers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if (log.equals("enter")) {
                workers.add(name);
            } else {
                workers.remove(name);
            }
        }

        List<String> orderedWorkers = workers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        // set은 해시맵을 이용해서 삭제에 필요한 시간복잡도가 O(1)입니다. list의 삭제는 항상 O(n)입니다.

        for (String worker : orderedWorkers) {
            System.out.println(worker);
        }
    }
}
