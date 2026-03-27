package org.example.userDefineDSA.codingQuestions;

import java.util.Arrays;

public class LongestStrictlyIncreasingSubSequence {
    public int sol(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int j=0;
        int res=1;
        for(int i=1;i<n;i++){
            while(j<i){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    res = Math.max(res,dp[i]);
                }
                j++;
            }
            j=0;
        }
        return res;
    }
}
