package org.example.userDefineDSA.codingQuestions;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int mid = (n1+n2)/2;
        int k=0;
        int i=0;int j=0;
        boolean twoValue = (n1+n2)%2==0;
        double value1 = 0;
        double value2 = 0;
        while(k<=mid){
            if((i>=n1 && j<n2) ||  (i<n1 && j<n2 && nums1[i]>nums2[j])){
                if(k==mid){
                    value1 = nums2[j];
                }else if(twoValue && k==mid-1){
                    value2 = nums2[j];
                }
                j++;
            }
            else {
                if (k == mid) {
                    value1 = nums1[i];
                } else if (twoValue && k == mid - 1) {
                    value2 = nums1[i];
                }
                i++;
            }
            k++;
        }
        return twoValue ? (value1 + value2)/2 : value1;
    }
}
