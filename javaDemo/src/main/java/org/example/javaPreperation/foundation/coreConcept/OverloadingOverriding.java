package org.example.javaPreperation.foundation.coreConcept;

public class OverloadingOverriding {
    /*
    * Overloading ( same method name with different parameter name {compile-time})
    *   compile-time polymorphism
    * Overriding( same method name and parameters in child class {Runtime (dynamic binding)})
    *   runtime-polymorphism
    *
    *
    * */
    /// OVERLOADING
    static int add(int a,int b){
        return a + b;
    }
    static int add(int a,int b,int c){
        return add(a,b) + c;
    }
    // OVERRIDING
    static class Animal{
        void sound(){
            System.out.println("aaaa");
        }
    }
    static class Dog extends Animal{
        @Override
        void sound(){
            System.out.println("bbb");
        }
    }
    static void main() {
        System.out.println(add(23,42,34));
        Animal a = new Dog();
        a.sound();
    }

}
