package org.example.leetcode;

import java.util.Scanner;

public class EditDistance {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of Testcases: ");
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println("enter Word1 : ");
            String w1 = sc.next();
            System.out.println("enter Word2 : ");
            String w2 = sc.next();
            System.out.println(minDistance(w1,w2));
        }
    }
    public int minDistance(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0] = i;
        for(int j=0;j<=n;j++) dp[0][j] = j;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
}
