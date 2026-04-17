package org.example.userDefineDSA.miscllaneous;

public class SearchInSortedRotatedArray {
    public int sol(int[] arr,int target){
        int l = 0, r = arr.length-1;
        while (r >= l){
            int m = l + (r - l )/2;
            if(arr[m]==target) return m;
            if(arr[m]>=arr[l]){
                if(target >= arr[l] && target < arr[m]){
                    r = m -1;
                }else{
                    l = m + 1;
                }
            }else{
                if(target > arr[m] && target <= arr[r]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
