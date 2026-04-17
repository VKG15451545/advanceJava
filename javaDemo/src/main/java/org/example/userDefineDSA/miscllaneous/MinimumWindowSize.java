package org.example.userDefineDSA.miscllaneous;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumWindowSize {
    public String finalSolution(String s,String t){
        // "ADOBECODEBANC", "ABC"
        int tlen = t.length();
        int slen = s.length();
        if(tlen > slen || slen ==0 || tlen ==0){
            return "";
        }
        int l=0,r=0;
        int[] freq = new int[123];// 65->90 97->122
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int count = tlen;
        char[] sChar = s.toCharArray();
        int minLen = Integer.MAX_VALUE;
        int stIdx = 0;
        while (r<slen){
            if(freq[sChar[r]]-->0){
                count--;
            }
            while (count == 0){
                if(minLen > (r - l + 1)){
                    minLen = r - l + 1;
                    stIdx = l;
                }
                freq[sChar[l]]++;
                if(freq[sChar[l]]>0){
                    count++;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(stIdx,stIdx+minLen);
    }
    public String minWindow(String s, String t) {
        int minWsize = t.length();
        int end = s.length();

        int[] tFreq = calculateF(t);
        int l = 0;
        for (int i = minWsize; i <= end; i++) {
            int[] currfreq = new int[52];
            Queue<Integer> q = new ArrayDeque<>();
            for (int j = 0; j < end; j++) {
                if (!q.isEmpty() && (j - q.peek() + 1) > i) {
                    int sIdx = q.poll();
                    if (s.charAt(sIdx) >= 'A' && s.charAt(sIdx) <= 'Z') {
                        currfreq[s.charAt(sIdx) - 'A']--;
                    } else {
                        currfreq[26 + (s.charAt(sIdx) - 'a')]--;
                    }
                }
                q.add(j);
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                    currfreq[s.charAt(j) - 'A']++;
                } else {
                    currfreq[26 + (s.charAt(j) - 'a')]++;
                }
                if (isSubString(currfreq, tFreq)) {
                    return s.substring(j - i + 1, j+1);
                }
            }
        }
        return "";
    }

    public int[] calculateF(String str) {   // 65-90, // 97-122
        int[] freq = new int[52];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                freq[str.charAt(i) - 'A']++;
            } else {
                freq[26 + (str.charAt(i) - 'a')]++;
            }
        }
        return freq;
    }

    public boolean isSubString(int[] curr, int[] t) {
        for (int i = 0; i < 52; i++) {
            if (t[i] > curr[i]) {
                return false;
            }
        }
        return true;
    }

    static void main(String[] args) {
        System.out.println(new MinimumWindowSize().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("finalSOlution: ");
        System.out.println(new MinimumWindowSize().finalSolution("ADOBECODEBANC", "ABC"));
        int x = 10;
        if(x < 5 && x++ >= 10){
            ;
        }
        System.out.println(x);
    }

}
