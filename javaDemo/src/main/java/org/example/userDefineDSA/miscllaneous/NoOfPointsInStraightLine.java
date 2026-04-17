package org.example.userDefineDSA.miscllaneous;

import java.util.HashMap;
import java.util.Map;

public class NoOfPointsInStraightLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int max = 0;
        for(int i=0;i<n;i++){
            int duplicates = 1;
            Map<String,Integer> map = new HashMap<>();
            for (int j=i+1;j<n;j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][0] - points[i][1];
                if(dx == 0 && dy ==0 ){ duplicates++;continue;}
                int g = gcd(dx,dy);
                dx = dx/g;
                dy = dy/g;
                if(dx < 0 ){
                    dx = -dx;
                    dy = -dy;
                }
                String key = dx + "_" + dy;
                map.put(key,map.getOrDefault(key,0)+1);
            }
            int currMax = 0;
            for(int val : map.values()){
                currMax = currMax>val ? currMax : val;
            }
            max = Math.max(max,duplicates+currMax);
        }
        return max;

    }
    private int gcd(int a ,int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static void main(String[] args) {
        NoOfPointsInStraightLine noOfPointsInStraightLine = new NoOfPointsInStraightLine();
        System.out.println(noOfPointsInStraightLine.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }
}
