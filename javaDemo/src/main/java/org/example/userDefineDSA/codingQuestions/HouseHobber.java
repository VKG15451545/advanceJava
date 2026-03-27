package org.example.userDefineDSA.codingQuestions;

class  HouseHobber {
    int[] requiredValue = new int[1001];
    public int rob(int[] nums) {
        int n = nums.length;
        int tempSum=0;
        for(int i=0;i<n;i++){
            tempSum+=nums[i];
            if(tempSum>0) break;
        }
        if(tempSum==0) return 0;
        int res = sol(nums,0);

        return res;
    }
    public int sol(int[] nums,int st){
        if(st>=nums.length){
            return 0;
        }
        if(requiredValue[st]>0){
            return requiredValue[st];
        }
        int res1 = nums[st] + sol(nums,st+2);
        int res2 = sol(nums,st+1);
        requiredValue[st]=Math.max(res1,res2);
        return requiredValue[st];
    }
}
