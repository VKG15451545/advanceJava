package org.example.userDefineDSA.codingQuestions;

public class MegaPrimeCount {
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public boolean hasPrimeDigit(int n){
        //2,3,5,7
        while (n>0){
            int digit = n%10;
            n = n/10;
            if(digit !=2 && digit!=3 && digit!=5 && digit!=7){
                return false;
            }
        }
        return true;
    }
    public int countMegaPrime(int st,int end){
        int res =0;
        for(int i=st;i<=end;i++){
            if(isPrime(i) && hasPrimeDigit(i)) res++;
        }
        return res;
    }
}
