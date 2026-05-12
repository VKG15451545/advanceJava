package org.example.javaPreperation.foundation.coreConcept.singletonClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClassDemo {
    static void main(String[] args) {
        BasicSingleton basicSingleton1 = BasicSingleton.getInstance();
        BasicSingleton basicSingleton2 = BasicSingleton.getInstance();
        System.out.println(basicSingleton2==basicSingleton1); // print true
        // Reflection Breaking Singleton
        try {
            Constructor<BasicSingleton> c = BasicSingleton.class.getDeclaredConstructor();
            c.setAccessible(true);
            BasicSingleton bs1 = c.newInstance();
            BasicSingleton bs2 = c.newInstance();
            System.out.print("bs1 == bs2: ");
            System.out.print(bs1 == bs2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
