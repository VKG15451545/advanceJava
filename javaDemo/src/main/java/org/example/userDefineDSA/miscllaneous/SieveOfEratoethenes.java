package org.example.userDefineDSA.miscllaneous;

import java.util.Arrays;

public class SieveOfEratoethenes {
    public boolean[] isPrimeNumber(int n){
        boolean[] res = new boolean[n+1];
        Arrays.fill(res,true);
        res[0]=res[1]=false;
        for(int i=2;i<=n;i++){
            if(res[i]){
                for(int j=i*i;j<=n;j=j+i){
                    res[j]=false;
                }
            }
        }
        return res;
    }
}
