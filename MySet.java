package com.company.models;

import java.util.ArrayList;

public class MySet {

    private static final ArrayList<Object> innerRa = new ArrayList<>();

    public MySet(){

    }

    private ArrayList<Object> getInstance(){
        return innerRa;
    }
    public void add(String item){
        if( ! getInstance().contains(item) ){
            getInstance().add(item);
        }
    }

    public int size() {
        return getInstance().size();
    }

    public void delete(String s) {
        getInstance().remove(s);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for(int i = 0; i < getInstance().size(); i++){
            stringBuilder.append(getInstance().get(i).toString());
            if(i != getInstance().size() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
