package org.example.javaPreperation.foundation.coreConcept.singletonClass;

public class BillPughSingleton {
    private BillPughSingleton(){};
    private static class Holder{
        private static final BillPughSingleton instance = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return Holder.instance;
    }
    /*
    * 1.Thread Safe
    * 2.Lazy initialization
    * 3. No synchronization overhead
    * 4. uses JVM class loading guarantees (jvm class loading guarantees thread safety)
    * : during class initialization jvm allows only one thread
    * */
}
