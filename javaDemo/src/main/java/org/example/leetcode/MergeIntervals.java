package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public ArrayList<int[]> solution(int[][] intervals){
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        ArrayList<int[]> l = new ArrayList<>();
        int st = intervals[0][0];
        int end = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(end >= intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
            }else{
                l.add(new int[]{st,end});
                st=intervals[i][0];
                end = intervals[i][1];
            }
        }
        l.add(new int[]{st,end});
        return l;
    }
}
