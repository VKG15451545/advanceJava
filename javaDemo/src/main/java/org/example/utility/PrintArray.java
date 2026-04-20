package org.example.utility;

public class PrintArray {
    public void arr2D(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length-1]+"]");
    }
}
