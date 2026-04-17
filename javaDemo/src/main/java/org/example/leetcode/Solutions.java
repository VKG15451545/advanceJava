package org.example.leetcode;

import org.example.utility.GetClassByName;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Solutions {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Problems:");
        for(EnumProblemName prob : EnumProblemName.values()){
            System.out.println(prob.getId() + "." + prob.getDescription());
        }
        int probSeq = sc.nextInt();
        if(Arrays.stream(EnumProblemName.values()).anyMatch(x->x.getId()==probSeq)){
            try{
                 Class<?> clazz = EnumProblemName.getById(probSeq);
                 Object obj = clazz.getDeclaredConstructor().newInstance();
                 Method method = clazz.getMethod("solution");
                 method.invoke(obj);
            } catch (Exception e) {
                System.out.println("Class doesn't exist");
            }
        }
    }
}
