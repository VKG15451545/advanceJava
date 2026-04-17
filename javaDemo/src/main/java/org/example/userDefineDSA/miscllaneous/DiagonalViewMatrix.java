package org.example.userDefineDSA.miscllaneous;

import java.util.ArrayList;

public class DiagonalViewMatrix {
    static ArrayList<Integer> diagView(int[][] mat) {
        // code here
        int n = mat.length;
        // 2n-1;
        ArrayList<Integer>[] res = new ArrayList[2*n-1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<(2*n -1);i++){
            res[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[i+j].add(mat[i][j]);
            }
        }
        for(int i=0;i<(2*n -1);i++){
            for(int j=0;j<res[i].size();j++){
                ans.add(res[i].get(j));
            }
        }
        return ans;
    }

    static void main(String[] args) {
        ArrayList<Integer> res = diagView(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(res);
    }
}
