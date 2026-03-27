package org.example.userDefineDSA.miscllaneous;

public class Solutions {
    static void main(String[] args) {
        SieveOfEratoethenes s = new SieveOfEratoethenes();
        boolean[] res = s.isPrimeNumber(1020);
        for(int i=0;i<res.length;i++){
            if(res[i]){
                System.out.print(i+",");
            }
        }
    }
}
