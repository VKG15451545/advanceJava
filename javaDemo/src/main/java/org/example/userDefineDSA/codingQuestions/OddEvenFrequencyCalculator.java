package org.example.userDefineDSA.codingQuestions;

public class OddEvenFrequencyCalculator {
    public static boolean canBeEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] s1_e_f = new int[26];
        int[] s2_e_f = new int[26];
        int[] s1_o_f = new int[26];
        int[] s2_o_f = new int[26];
        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                s1_e_f[s1.charAt(i)-'a']++;
                s2_e_f[s2.charAt(i)-'a']++;
            }
            else{
                s1_o_f[s1.charAt(i)-'a']++;
                s2_o_f[s2.charAt(i)-'a']++;
            }
        }
        if(s1_e_f == s2_e_f && s2_o_f == s1_o_f ){
            return true;
        }
        return false;

    }

    static void main(String[] args) {
        System.out.println(canBeEqual("abcd","cabd"));
    }
}
