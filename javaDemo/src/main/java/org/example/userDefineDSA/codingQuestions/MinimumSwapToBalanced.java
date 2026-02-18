package org.example.userDefineDSA.codingQuestions;

public class MinimumSwapToBalanced {
    public int solution(String s){
        int open=0;
        int imb =0;
        for(Character ch : s.toCharArray()){
            if(ch=='['){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    imb++;
                }
            }
        }
        return (imb+1)/2 ;
    }
}
