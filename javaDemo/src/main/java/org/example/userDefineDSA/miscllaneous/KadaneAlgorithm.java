package org.example.userDefineDSA.miscllaneous;

public class KadaneAlgorithm {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for(int i=1;i<n;i++){
            int num = nums[i];
            currMax = Math.max(num + currMax,num);
            currMin = Math.min(num+currMin,num);
            max = Math.max(max,currMax);
            min = Math.min(min,currMin);
            sum += num;
        }
        return Math.max(max,sum-min);
    }

}
