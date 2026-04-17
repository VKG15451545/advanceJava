package org.example.leetcode;

import java.util.*;

public class SeventeenApril {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(map.containsKey(mirror(nums[i]))){
                res = Math.min(res,diff(i,map.get(mirror(nums[i]))));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int mirror(int i){
        int s = 0;
        String str = String.valueOf(i);
        for(int j=str.length()-1;j>=0;j--){
            s = s*10 + str.charAt(j)-'0';
        }
        return s;
    }
    public int diff(int idx,List<Integer> l){
        int diff = Integer.MAX_VALUE;
        int lastIdx = l.get(l.size()-1);
        int firstIdx = l.get(0);
        if(idx <  lastIdx){
            diff = Math.min(diff, lastIdx-idx);
        }
        if(idx < firstIdx){
            diff = Math.min(diff, firstIdx-idx);
        }
        return diff;
    }
    public void solution(){
        Scanner sc = new Scanner(System.in);
        System.out.println("no. of testcasesToCheck : ");
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println("enter size of an array: ");
            int arrSize = sc.nextInt();
            int[] arr = new int[arrSize];
            System.out.println("enter values of an array:");
            for(int j=0;j<arrSize;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println("ans: " + minMirrorPairDistance(arr));
        }
    }
}
