package org.example.javaPreperation.foundation.coreConcept.singletonClass;

import java.io.Serializable;

public class ProductionLevelSingleton implements Serializable,Cloneable
{
    private static ProductionLevelSingleton instance;
    private ProductionLevelSingleton(){
        if(instance != null){  // prevent reflection
            throw new RuntimeException(
                    "Use getInstance");
        }
    }
    public static ProductionLevelSingleton getInstance(){
        if(instance == null){
            synchronized (ProductionLevelSingleton.class){
                if(instance == null){
                    instance = new ProductionLevelSingleton();
                }
            }
        }
        return instance;
    }
    protected Object readResolve(){ //deserialization
        return instance;
    }
    // prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


}
