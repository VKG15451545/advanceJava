package org.example.javaPreperation.foundation.coreConcept;

public final class ImmutableExample {
    /*
     1. Immutable class is a class whose object cannot be modified once created.
     2. Example : (String,Integer,LocalDate)
     3. Thread-Safety,Reliability,Security
     4. Rule:
        1. final class ( subClass modification)
        2. private final fields (direct/later modification)
        3. no setters
     */
    private final String fieldName;

    private final int value;
    public ImmutableExample(String name,int value){
        this.fieldName = name;
        this.value = value;
    }
    public String getFieldName(){
        return this.fieldName;
    }
    public int getValue(){
        return this.value;
    }
    //--No setter immutability preserved;
}
