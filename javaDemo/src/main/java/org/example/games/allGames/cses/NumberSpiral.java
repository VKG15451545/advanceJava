package org.example.games.allGames.cses;

import org.example.games.Game;

import java.util.Scanner;

public class NumberSpiral implements Game {
    @Override
    public void start(Scanner sc) {
        System.out.println("Enter the size of matrix to print Spiral matrix: ");
        solve(sc);


    }
    public static void solve(Scanner sc){
        Integer s = sc.nextInt();
        if(s == null || s<0){
            System.out.println("enter Valid Integer between 0 to 100");
            solve(sc);
        }
        printMatrix(sc,s);
    }
    public static void printMatrix(Scanner sc,Integer n){
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        int k = (n-1)*(n-1)+1;
        int st_c = 1;
        int st_r =0;
        boolean rowWise = (n%2==0);
        int maxCountSum= 1+ 2*(n-1);
        for(int i=n;i>=1;i--){
            if(rowWise) {
                for(int j=i;j>=maxCountSum/2+1;j--){
                    matrix[st_r][st_c] = k;
                    st_r++;
                    k--;
                }
                for(int j=i;j>=maxCountSum/2;j--){
                    st_c--;
                    matrix[st_r][st_c] = k;
                    k--;
                }
                maxCountSum = maxCountSum -2;
                rowWise = false;
            }else{
                st_r--;
                for(int i1=maxCountSum/2+1;i1<=1;i1--){
                    matrix[st_r][st_c]=k;
                    st_c++;
                    k--;
                }
                st_r--;
                for(int i2=maxCountSum/2;i2<=1;i2--){
                    matrix[st_r][st_c] = k;
                    st_r--;
                    k--;
                }
                maxCountSum = maxCountSum -2;
                rowWise = true;
            }
        }

    }

}
