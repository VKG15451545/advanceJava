package org.example.utility;

public class GetClassByName {
    public Class<?> getClassByName(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }
}
