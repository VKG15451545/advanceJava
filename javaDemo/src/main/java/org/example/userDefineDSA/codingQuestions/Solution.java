package org.example.userDefineDSA.codingQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    static class Meeting{
        int st,end,pos;
        Meeting(int st,int end,int pos){
            this.st = st;
            this.end = end;
            this.pos = pos;
        }
    }

    static void main(String[] args) {
        int[] start =  {0,3,1,5,8,5};
        int[] end =  {5,4,2,7,9,9};
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i],end[i],i+1));
        }
        Collections.sort(meetings,(a,b)->a.end-b.end);
        List<Integer> res = new ArrayList<>();
        res.add(meetings.get(0).pos);
        int lastENd = meetings.get(0).end;
        for (int i=0;i<n;i++){
            if(meetings.get(i).st >= lastENd){
                res.add(meetings.get(i).pos);
                lastENd = meetings.get(i).end;
            }
        }
        for(int meet : res){
            System.out.print(","+(meet-1));
        }
//        System.out.println("size: "+res.size());
    }
}
