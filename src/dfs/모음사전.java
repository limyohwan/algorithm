package dfs;

import java.util.*;

public class 모음사전 {
    String[] words = {"A", "E", "I", "O", "U"};
    List<String> dictionary = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            dfs(words[i], "");
        }

        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                return i;
            }
        }

        return answer;
    }

    public void dfs(String word, String result) {
        if (result.length() > 5) {
            return;
        }

        if (!dictionary.contains(result)) {
            dictionary.add(result);
        }

        for (int i = 0; i < words.length; i++) {
            dfs(words[i], result + words[i]);
        }
    }
}
