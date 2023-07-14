package com.company.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    @Test
    void itDoesTheThing(){
        assertTrue(true);
    }

    @Test
    void addDoesntBreakStuff(){
        MySet mySet = new MySet();
        mySet.add("123");
        assertEquals(mySet.size(),1);
    }

    @Test
    void addDoesntBreakStuffMultiplesSizeShouldBe1(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("123");
        mySet.add("123");
        mySet.add("123");
        // size should still be 1
        assertEquals(mySet.size(),1);
    }

    @Test
    void addDoesntBreakStuffMultiplesSizeShouldBe3(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("456");
        mySet.add("789");
        // size should be 3
        assertEquals(mySet.size(),3);
    }

    @Test
    void deleteDoesntBreakStuffMultiplesSizeShouldBe2(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("456");
        mySet.add("789");
        mySet.delete("456");
        // size should be 2
        assertEquals(mySet.size(),2);
    }

    @Test
    void deleteDoesntBreakStuffMultipleDeletionSameObjectSizeShouldBe2(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("456");
        mySet.add("789");
        mySet.delete("123");
        mySet.delete("123");
        mySet.delete("123");
        mySet.delete("123");
        // size should be 2
        assertEquals(mySet.size(),2);
    }

    @Test
    void deleteDoesntBreakStuffMultipleDeletionSameObjectThenAddAgaginSizeShouldBe3(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("456");
        mySet.add("789");
        mySet.delete("123");
        mySet.delete("123");
        mySet.delete("123");
        mySet.delete("123");
        // size should be 2
        mySet.add("123");
        mySet.add("123");
        mySet.add("123");
        assertEquals(mySet.size(),3);
    }

    @Test
    void deleteDoesntBreakStuffMultiplePrintsOutToStringCorrectly(){
        MySet mySet = new MySet();
        mySet.add("123");
        mySet.add("456");
        mySet.add("789");
        // toString will print in order (remember set is unordered)
        String str = mySet.toString();
        assertEquals("{ 123, 456, 789 }", str);

        mySet.delete("123");
        assertEquals(mySet.size(),2);

        mySet.add("123");
        String str1 = mySet.toString();

        assertEquals("{ 456, 789, 123 }", str1);
        // 123 should print at the end now
        assertEquals(mySet.size(),3);
    }

}
