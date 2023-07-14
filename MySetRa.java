package com.company.models;

import java.util.Arrays;

public class MySetRa {
  
    // start size 0, size is the number of filled elements, not the array length
    private int raSize = 0;
  
    // start size as 10, flex and grow as necessary
    private static Object[] innerRa = new Object[10];


    public MySetRa(){
        // fill with nulls, nulls tell us the spot is free for writing
        init();
    }

    // initializer function
    public void init(){
        Arrays.fill(getInstance(), null);
    }

    // return an array of object, this is the data structure that represents 
    public Object[] getInstance(){
        return innerRa;
    }

    // add object only if unique (set is unordered unique items)
    public void add(Object obj){
        if(contains(obj)){
            return;
        }
        if(size()== getInstance().length){
            growRa();
        }
        for(int i = 0; i < getInstance().length; i++){
            if(getInstance()[i]==null){
                // we found a home for our unordered friend to insert
                // usually this'll be an open spot in sequence
                getInstance()[i] = obj;
                incrementSize();
                break;
            }
        }
    }

    // grow the array if it's too small to contain a new element
    private void growRa() {
        // increase by ten
        Object[] newRa = new Object[size()+10];
        // copy
        for( int i = 0; i < getInstance().length; i++){
            newRa[i] = getInstance()[i];
        }
        // instead of initializing the entire array as null, then filling
        // it's more efficient to start where the copy loop left off, it saves half an iteration or n/2
        for( int i = size(); i < newRa.length; i ++){
            newRa[i] = null;
        }
        innerRa = newRa;
    }

    // this is the size that is incremented and decremented as items are added
    public int size() {
        return this.raSize;
    }

    // increments the size
    public void incrementSize() {
        this.raSize += 1;
    }

    // decrements the size
    private void decrementSize() {
        this.raSize -= 1;
    }

    // removes the element
    public void delete(String s) {
        for( int i = 0; i < getInstance().length; i++ ){
            if(getInstance()[i].equals(s)){
                // move item from end to fill the hole, null out the end value
                getInstance()[i] = getInstance()[this.size()-1];
                getInstance()[this.size()-1] = null;
                decrementSize();
                break;
            }
        }
    }

    // checks if item is inside the array
    public boolean contains(Object s) {
        for( int i = 0; i < getInstance().length; i++ ){
            if(s.equals(getInstance()[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for(int i = 0; i < size(); i++){
            stringBuilder.append(getInstance()[i].toString());
            if(i != size() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
