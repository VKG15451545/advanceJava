package org.example.leetcode;

public class CountDearrangeMent {
    public static long derangeCount(int n) {
       if(n == 0) return 1;
       if(n == 1) return 0;
       long prev2 = 1;
       long prev1 = 0;
       long curr = 0;
       for(int i=2;i<=n;i++){
           curr = (i-1)*(prev1 + prev2);
           prev2 = prev1;
           prev1 = curr;
       }
       return curr;
    }

    static void main(String[] args) {
        System.out.println(derangeCount(4));
    }
}
