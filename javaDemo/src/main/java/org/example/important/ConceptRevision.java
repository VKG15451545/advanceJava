package org.example.important;

import org.example.leetcode.EnumProblemName;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ConceptRevision {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("select Concept : ");
        for(EnumConceptName enumConceptName : EnumConceptName.values()){
            System.out.println(enumConceptName.getId()+"."+ enumConceptName.getName() + ":"+enumConceptName.getDesc());
        }
        try{
            Class<?> clazz = EnumProblemName.getById(sc.nextInt());
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod("revision");
            method.invoke(obj);
        } catch (Exception e) {
            System.out.println("Incorrect Selection");
        }
    }
}
