package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanSplitOrNot {
    public void solution(){

    }
    public static boolean method1(int[] arr){

            // code here
            int totalSum = 0;
            for(int i : arr) totalSum += i;
            int psum=0;
            for(int i=1;i<arr.length;i++){
                psum += arr[i];
                if(psum == totalSum - psum) return true;
            }
            return false;

    }

    static void main(String[] args) {
        method1(new int[]{4,3,2,1});
        distance(new int[]{1,3,1,1,2});
    }
    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer,Long> fmap = new HashMap<>();
        Map<Integer,Long> map = new HashMap<>();
        Map<Integer,Long> map2 = new HashMap<>();
        Map<Integer,Long> bmap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                fmap.put(i,map.get(nums[i])+(long)i);
                map.put(nums[i],map.get(nums[i])+(long)i);
            }else{
                fmap.put(i,(long)i);
                map.put(nums[i],(long)i);
            }
            if(map2.containsKey(nums[n-1-i])){
                bmap.put(n-1-i,map2.get(nums[n-1-i])+(long)(n-1-i));
                map2.put(nums[n-1-i],map2.get(nums[n-1-i])+(long)(n-1-i));
            }else{
                map2.put(nums[n-1-i],(long)n-1-i);
                bmap.put(n-1-i,(long)n-1-i);
            }
        }
        for(int i=0;i<n;i++){
            res[i] = fmap.get(i) + bmap.get(i) - (long)i*2;  // 0 2 3
        }
        return res;
    }
}
