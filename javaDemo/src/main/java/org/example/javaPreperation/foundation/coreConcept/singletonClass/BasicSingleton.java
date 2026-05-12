package org.example.javaPreperation.foundation.coreConcept.singletonClass;
// Eager Initialization
class BasicSingleton {
    private static boolean initialezed = false;
    private static BasicSingleton instance = new BasicSingleton(); // static object ( 1 object created)
    private BasicSingleton(){
        // protection against reflection
        if(initialezed) throw new RuntimeException(
                "Singleton Broken"
        );
        initialezed = true;
    }; // new object creation not allowed
    public static BasicSingleton getInstance(){ // public method to access already created instance
        return instance;
    }
    // object is created when application start
    // simple and thread safe
    // object is created even though it is not needed
}
