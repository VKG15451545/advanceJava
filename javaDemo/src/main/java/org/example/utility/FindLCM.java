package org.example.utility;

public class FindLCM {
    public Long solution(int[] arr){
        Long currLcm = (long) arr[0];
        for(int i=1;i<arr.length;i++){
            currLcm = (currLcm * arr[i])/GreatestCommonDivisor.findGcd(currLcm,(long)arr[i]);
        }
        return currLcm;
    }
}
