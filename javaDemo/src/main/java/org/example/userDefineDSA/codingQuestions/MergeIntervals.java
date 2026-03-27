package org.example.userDefineDSA.codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] sol(int[][] arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int st = arr[0][0];
        int end = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(end >= arr[i][0]){
                end = Math.max(end,arr[i][1]);
            }else{
                res.add(new int[]{st,end});
                st = arr[i][0];
                end = arr[i][1];
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
