package org.example.leetcode;

public enum EnumProblemName {
    SeventeenApril(1,"SeventeenApril","3761. Minimum Absolute Distance Between Mirror Pairs"),
    EditDistance(2,"EditDistance","Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2(EDIT/DELETE/REPLACE)");
    private int id;
    private String name;
    private String description;
    EnumProblemName(int id,String name,String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public static Class<?> getById(int id) throws ClassNotFoundException {
        for(EnumProblemName enumProblemName : EnumProblemName.values()){
            if(enumProblemName.getId()==id){
                return Class.forName("org.example.leetcode."+ enumProblemName.getName());
            }
        }
        return null;
    }
}
