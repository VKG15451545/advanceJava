package org.example.userDefineDSA.miscllaneous;

import java.util.List;

public class Solutions {
    static void main(String[] args) {
        SieveOfEratoethenes s = new SieveOfEratoethenes();
        boolean[] res = s.isPrimeNumber(1020);
        for(int i=0;i<res.length;i++){
            if(res[i]){
                System.out.print(i+",");
            }
        }
        RobotCollisions rbc = new RobotCollisions();
        List<Integer> rbc_res = rbc.solution(new int[]{10,10,15,12},new int[]{3,5,2,6},"RLRL");
        System.out.println();
        for(int abc : rbc_res){
            System.out.print(abc+",");
        }
    }
}
