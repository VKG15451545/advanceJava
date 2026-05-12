package org.example.utility;

public class GreatestCommonDivisor {

    public static Long findGcd(Long v1, Long v2){
        if(v2==0) return v1;
        return findGcd(v2,v1 % v2);
    }
}
