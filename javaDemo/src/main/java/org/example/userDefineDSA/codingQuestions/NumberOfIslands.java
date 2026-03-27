package org.example.userDefineDSA.codingQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public int bfs(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int res = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int qsize = q.size();
                        for(int k=0;k<qsize;k++){
                            int[] node = q.poll();
                            for(int d=0;d<4;d++){
                                int c_r = node[0]+ dir[d][0];
                                int c_c = node[1] + dir[d][1];
                                if(c_r < r && c_r >=0 && c_c < c && c_c >= 0 && !visited[c_r][c_c]){
                                    visited[c_r][c_c]=true;
                                    if(grid[c_r][c_c]=='1'){
                                        q.add(new int[]{c_r,c_c});
                                    }
                                }
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;

    }
    public int dfs(char[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                  res++;
                  solve(grid,i,j);
                }
            }
        }
        return res;
    }
    public void solve(char[][] grid,int i,int j){
        int r = grid.length;
        int c = grid.length;
        if(i >=r || i<0 || j >= c || j<0 || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        solve(grid,i+1,j);
        solve(grid,i-1,j);
        solve(grid,i,j+1);
        solve(grid,i,j-1);
    }
}
