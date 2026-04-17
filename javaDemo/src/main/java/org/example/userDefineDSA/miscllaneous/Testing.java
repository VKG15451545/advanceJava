package org.example.userDefineDSA.miscllaneous;

public class Testing {
    static void main(String[] args) {
        Integer a = 1327;
        Integer b = 1327;
        Integer a1 = 20;
        Integer b1 = 20;
        System.out.println(a.equals(b));
        System.out.println(a1==b1);
        KadaneAlgorithm kd = new KadaneAlgorithm();
        System.out.println(kd.maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
