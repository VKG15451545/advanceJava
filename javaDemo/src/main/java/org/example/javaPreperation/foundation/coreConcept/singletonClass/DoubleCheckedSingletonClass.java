package org.example.javaPreperation.foundation.coreConcept.singletonClass;

public class DoubleCheckedSingletonClass {
    private static volatile DoubleCheckedSingletonClass instance;
    private DoubleCheckedSingletonClass(){};
    public static DoubleCheckedSingletonClass getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedSingletonClass.class){
                if(instance == null){
                    instance = new DoubleCheckedSingletonClass();
                }
            }
        }
        return instance;
    }
    // volatile : visibility and prevent instruction reordering and partially initialized object
    // **> java runs in multithreaded environment so each thread will have its own cpu,memory so one thread may not immediate visible to other thread

    /*
     * object creation is not atomic inside actual machine(jvm)
     * 1. allocate memory
     * 2. assign reference
     * 3. initialize object  (jvm may reorder for its performance)
     *   what volatile do -> 1(allocate memory)->3(initialize object)->2(assign reference)
     *
     *
     *
     *
     * */
}
