package org.example.userDefineDSA.codingQuestions;

import java.util.*;

public class WordLadder {
    public int sol(String st, String end, List<String> words){
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSets = new HashSet<>(words);
        visited.add(st);
        q.add(st);
        int level = 0;
        while (!q.isEmpty()){
            int qsize = q.size();
            for(int j=0;j<qsize;j++) {
                String currWord = q.poll();
                if (currWord.equals(end)) {
                    return level;
                }
                for (int i = 0; i < currWord.length(); i++) {
                    char[] chars = currWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (wordSets.contains(newWord) && !visited.contains(newWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                            wordSets.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
