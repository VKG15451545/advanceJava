package org.example.userDefineDSA.codingQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public int sol(int[] arr,int k){
        int pSum=0,res =0; // psum - prev = k;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : arr){
            pSum += num;
            if(map.containsKey(pSum-k)){
                res += map.get(pSum-k);
            }
            map.put(pSum,map.getOrDefault(pSum,0)+1);
        }
        return res;
    }
}
