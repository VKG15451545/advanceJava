package org.example.userDefineDSA.miscllaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KpairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->((a[0]+a[1])-(b[0]-b[1])));
        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }
        while(k-->0 && !pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int v = node[1];
            int y = node[2];
            res.add(Arrays.asList(u,v));
            if(y+1<nums2.length){
                pq.offer(new int[]{u,nums2[y+1],y+1});
            }
        }
        return res;
    }
}
