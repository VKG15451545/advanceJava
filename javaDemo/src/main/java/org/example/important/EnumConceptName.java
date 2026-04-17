package org.example.important;


public enum EnumConceptName {
    DIJASTRA_ALGORITHM(1,"DijastraAlgorithm","Shortest distance from a source node to all other nodes."),
    GENERIC_HEAP_IMPLEMENTATION(2,"GenericHeap","min/max heap implemtation");
    private int id;
    private String name;
    private String desc;
    EnumConceptName(int id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public String getDesc(){return desc;}
    public static Class<?> getById(int id) throws ClassNotFoundException {
        for(EnumConceptName enumProblemName : EnumConceptName.values()){
            if(enumProblemName.getId()==id){
                return Class.forName("org.example.important."+ enumProblemName.getName());
            }
        }
        return null;
    }
}
