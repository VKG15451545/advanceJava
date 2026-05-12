package org.example.javaPreperation.foundation.coreConcept.singletonClass;

public class LazyInitializationSingletonClass {
    private static LazyInitializationSingletonClass instance;
    private LazyInitializationSingletonClass(){};
    public static LazyInitializationSingletonClass getInstance(){
        if(instance==null){
            instance = new LazyInitializationSingletonClass();
        }
        return instance;
    }
    // not thread safe
    // multiple thread can create multiple instances
}
