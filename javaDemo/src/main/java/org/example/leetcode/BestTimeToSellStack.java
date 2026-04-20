package org.example.leetcode;

import java.util.Scanner;

public class BestTimeToSellStack {
    public void solution(){
        System.out.println("enter no. of testcases");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println("enter size of an array: ");
            int arrS = sc.nextInt();
            int[] arr = new int[arrS];
            for(int j=0;j<arrS;j++){
                System.out.print(j+1+":");
                arr[j]=sc.nextInt();;
            }
            System.out.println(method1(arr));
        }
    }
    public int method1(int[] arr){
        int buy=0,sell=0,profit=0;
        while (sell<arr.length){
            if(arr[buy]<arr[sell]){
                profit = Math.max(profit,arr[sell]-arr[buy]);
            }else{
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}
