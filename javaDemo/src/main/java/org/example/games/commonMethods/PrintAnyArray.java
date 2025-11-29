package org.example.games.commonMethods;

public class PrintAnyArray {
    public static <T> void print2DArray(T[][] array){
        if(array == null || array.length==0) {
            System.out.println("empty");
            return;
        }
        System.out.print("[");
        for(T[] arr: array){
            System.out.print("(");
            for(T value: arr){
                System.out.print(value +",");
            }
            System.out.print(")");
            System.out.println();
        }
    }
}
