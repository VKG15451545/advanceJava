package org.example.userDefineDSA.codingQuestions;

import java.util.*;

public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int num : nums){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y)->(x.getValue()-y.getValue()));
        PriorityQueue<Map.Entry<Integer,Integer>> pq1 = new PriorityQueue<>((x,y)->(y.getValue()-x.getValue()));
        for(Map.Entry<Integer,Integer> entry : m.entrySet()){
            pq.add(entry);
            pq1.add(entry);
            if(pq.size()>k){
                pq.poll();
                pq1.poll();
            }
        }
        int[] res = new int[k];
        int[] res2 = new int[k];
        int i=0,j=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll().getKey();
            res2[j++] = Objects.requireNonNull(pq1.poll()).getKey();
        }
        return res;
    }
    public static int[] sol2(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            l.add(new ArrayList<>());
        }
        l.add(new ArrayList<>());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            l.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        k = 0;
        for(int i=l.size()-1;i>=0;i--){
            for(int val : l.get(i)){
                res[k++]=val;
                if(k==res.length){
                    break;
                }
            }
            if(k==res.length){
                break;
            }
        }
        return res;
    }

    static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,1,2,3,1,3,2};
        TopKFrequentElement tkfe = new TopKFrequentElement();
        int[] res = tkfe.topKFrequent(arr,2);
    }
}
