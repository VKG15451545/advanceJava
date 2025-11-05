package org.example.javaPreperation.foundation.coreConcept;

public class ShallowDeepCopy implements Cloneable {
    /*
    1. object in java lives in heap memory.
    2. shallow copy:
        #. copies only object's references not actual nested object inside it.
        #.
     */
    String copy;
    ShallowDeepCopy(String copy){
        this.copy = copy;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone(); //shallow copy
    }

    static void main() throws CloneNotSupportedException {
        Employee e1 = new Employee("Vikas",new Address("Chitrakoot"));
        Employee shallowCopyE1 = (Employee) e1.shallowCopy();
        Employee deepCopyE1 = (Employee) e1.deepCopy();
        System.out.println("deep/shallow copy add before address edited");
        System.out.println(shallowCopyE1);
        System.out.println(deepCopyE1);
        e1.address.city = "manikpur";
        System.out.println("after");
        System.out.println(shallowCopyE1.toString());
        System.out.println(deepCopyE1.toString());
    }

}
class Address implements Cloneable{
    String city;
    Address(String city){
        this.city = city;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String toString(){
        return city;
    }
}
class Employee implements Cloneable{
    String name;
    Address address;
    Employee(String name,Address address){
        this.name = name;
        this.address = address;
    }
    //shallow copy
    protected Object shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }
    // deep copy
    protected Object deepCopy() throws CloneNotSupportedException{
        Employee cloned = (Employee) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }
    @Override
    public String toString(){
       return "[name: "+name+",][address:"+address.city+"]";
    }
}

