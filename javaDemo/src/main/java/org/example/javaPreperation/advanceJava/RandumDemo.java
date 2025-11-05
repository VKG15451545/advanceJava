package org.example.javaPreperation.advanceJava;

import java.util.Random;
import java.util.Scanner;

public class RandumDemo {
    static void main() {
        Random random = new Random();
        int number;
        number = random.nextInt();
        int number2;
        number2 = random.nextInt(1,6); // origin inclusive and 6 is exclusive
        double vik = random.nextDouble();
        boolean isHead = random.nextBoolean();
        if(isHead){
            System.out.println("HEAD");
        }else{
            System.out.println("TAIL");
        }
        System.out.println("vik:"+vik);
        System.out.println(number);
        System.out.println("number2:"+number2);
        System.out.println("pi: "+Math.PI);
        System.out.println("e(euiler):"+Math.E);
        System.out.println("2^4:"+Math.pow(2,4));
        System.out.println("abssolute of -4: "+ Math.abs(4));
        System.out.println("square root of 9:"+ Math.sqrt(9));
        System.out.println("round of 3.145 ceil"+Math.ceil(3.145));
        System.out.println("round of 3.145 floor"+Math.floor(3.145));
        System.out.println("round of 3.145 round"+Math.round(3.145));
        System.out.println("max/min");

        Scanner sc = new Scanner(System.in);
        System.out.println("find the hypotenuse of right angle triangle press 'y'");
        String userRes = sc.next();
        if("y".equals(userRes)){
            System.out.println("enter length of sida A");
            double a = sc.nextDouble();
            System.out.println("enter length of side B");
            double b = sc.nextDouble();
            System.out.println("hypotenuse: "+Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
        }
        System.out.println("want to find circumference,area,volume press y");
        String userRes2 = sc.next();
        if(userRes2.equals("y")){
            System.out.println("enter radius of circle");
            double radius = sc.nextDouble();
            System.out.println("circumference:"+2*Math.PI*radius +",area: "+Math.PI*Math.pow(radius,2) + ",volume: "+(4/3)*Math.PI*Math.pow(radius,3));
            System.out.printf("circumference:%.1f,area:%.1f,volume:%.1f",2*Math.PI*radius,Math.PI*radius*radius,4/3*Math.PI*Math.pow(radius,3));
        }

        //Printf
        String name = "vikas";
        char firstLetter = 'V';
        double height = 60.3;
        int age = 43;
        boolean isEmployed = true;
        System.out.printf("Hello %s\n",name);
        System.out.printf("your name start with %c\n",firstLetter);
        System.out.printf("your age is %d\n",age);
        System.out.printf("your height is %f\n",height);
        System.out.printf("your are employed : %b",isEmployed);


        sc.close();
    }

}
