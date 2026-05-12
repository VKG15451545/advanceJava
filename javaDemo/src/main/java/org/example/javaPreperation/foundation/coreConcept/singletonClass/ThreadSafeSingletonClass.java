package org.example.javaPreperation.foundation.coreConcept.singletonClass;

class ThreadSafeSingletonClass {
    private static ThreadSafeSingletonClass instance;
    private ThreadSafeSingletonClass(){};
    public static synchronized ThreadSafeSingletonClass getInstance(){
        if(instance==null){
            instance = new ThreadSafeSingletonClass();
        }
        return instance;
    }
    // Lazy initialized (object is not created on start of application)
    // Thread safe but become slow due to "synchronized" keyWord
}
