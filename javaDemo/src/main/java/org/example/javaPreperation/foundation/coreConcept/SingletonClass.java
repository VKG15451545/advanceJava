package org.example.javaPreperation.foundation.coreConcept;

public class SingletonClass {
    /*
    1. only one instance of the class can be created and provides global point of access to that instance.
    2. used for ( Logging , Database connections,Configuration management,Caching)
    3. Key Features:
        1. Private constructor ( prevent object from outside)
        2. static instance variable (holds single instance)
        3. public static method (returns the instance)
        4. Thread-safety ( no 2 threads create multiple instance at once)
    **/
    private static volatile SingletonClass instance;  //volatile ensure visibility across threads
    private SingletonClass(){
        System.out.println("Singleton instance created.");
    }
    public static SingletonClass getInstance(){
        if(instance == null){
            synchronized (SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
    // ENUM BASED SINGLETON
    public enum SingletonEnum{
        INSTANCE;
        public void showMessage(){
            System.out.println("hello vikas");
        }
    }

    public static void main(String[] args) {
        SingletonEnum s1 = SingletonEnum.INSTANCE;
        SingletonEnum s2 = SingletonEnum.INSTANCE;
        s1.showMessage();
        System.out.println(s1==s2);
    }

}
