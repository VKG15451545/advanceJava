package org.example.leetcode;

public enum EnumProblemName {
    SeventeenApril(1,"SeventeenApril","3761. Minimum Absolute Distance Between Mirror Pairs"),
    EditDistance(2,"EditDistance","Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2(EDIT/DELETE/REPLACE)"),
    BEST_TIME_TO_BUY_SELL_STACK(3,"BestTimeToSellStack","You are given an array prices where prices[i] is the price of a given stock on the ith day.\n" +
            "\n" +
            "You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.\n" +
            "\n" +
            "Return the maximum profit you can achieve from this transaction."),
    MERGE_INTERVALS(3,"MergeIntervals",""),
    COUNT_DEARRANGEMENT(4,"CountDearrangeMent","");
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
