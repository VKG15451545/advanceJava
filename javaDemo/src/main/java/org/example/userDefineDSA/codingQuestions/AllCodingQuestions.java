package org.example.userDefineDSA.codingQuestions;

import java.util.HashSet;

public class AllCodingQuestions {
    static void main(String[] args) {
//        MinReversalToValidParanthesis m = new MinReversalToValidParanthesis();
//        String s1 = "}{{}}{{{";
//        System.out.println(m.solution(s1));
//        MegaPrimeCount mpc = new MegaPrimeCount();
//        System.out.println(mpc.countMegaPrime(2,343324));
//        MinPathSum mps = new MinPathSum();
//        int[][] mpsQ = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(mps.minPathSum(mpsQ));
//        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
//        int[] arr1 = new int[]{1,2,3,4,5};
//        int[] arr2 = new int[]{6,7,8,9,10,11,12,13,14,15,16,17};
//        int[] arr3 = new int[]{2,3};
//        int[] arr5 = new int[]{1};
//        int[] arr4 = new int[]{2,7};
//        System.out.println(medianOfTwoSortedArray.findMedianSortedArrays(arr3,arr5));
        String s1 = "Java";
        String s2 = "Ja" + "va";
        String s3 = "Java";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2));
            int res = 1;
            int temp = 1;
            String s = "abcabcbb";
            HashSet<Character> hs = new HashSet<>();
            hs.add(s.charAt(0));
            for(int i=1;i<s.length();i++){
                if(hs.contains(s.charAt(i))){
                    hs = new HashSet<>();
                    hs.add(s.charAt(i));
                    temp = 1;
                }else{
                    hs.add(s.charAt(i));
                    temp++;
                }
                res = Math.max(res,temp);
            }
        System.out.println(res);


    }
}
