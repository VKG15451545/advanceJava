package org.example.userDefineDSA.codingQuestions;

public class gcd {
    public static int sol(int a,int b){
        if(b==0){
            return a;
        }
        return sol(b,a%b);
    }
}
