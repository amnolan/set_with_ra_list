package com.company.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySetRaTest {

    @Test
    void doesTheThing(){
        assertTrue(true);
    }

    @Test
    void returnsInstanceNotNull(){
        MySetRa mySetRa = new MySetRa();
        assertNotNull(mySetRa.getInstance());
    }

    @Test
    void addToSetIncrementsSize(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        assertEquals(1,mySetRa.size());
    }

    @Test
    void addSeveralToSetIncrementsSize(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        mySetRa.add("456");
        mySetRa.add("789");
        assertEquals(3,mySetRa.size());
    }

    @Test
    void addSeveralToSetDecrementsSize(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        mySetRa.add("456");
        mySetRa.add("789");
        mySetRa.delete("456");
        assertEquals(2,mySetRa.size());
    }

    @Test
    void addSeveralToSetDecrementsSizeCheckingListRewrite(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        mySetRa.add("456");
        mySetRa.add("789");

        assertEquals(mySetRa.getInstance()[0],"123");
        assertEquals(mySetRa.getInstance()[1],"456");
        assertEquals(mySetRa.getInstance()[2],"789");
        assertNull(mySetRa.getInstance()[3]);

        mySetRa.delete("456");

        assertEquals(mySetRa.getInstance()[0],"123");
        assertEquals(mySetRa.getInstance()[1],"789");
        assertNull(mySetRa.getInstance()[2]);

        assertEquals(2,mySetRa.size());

        mySetRa.add("456");

        assertEquals(mySetRa.getInstance()[0],"123");
        assertEquals(mySetRa.getInstance()[1],"789");
        assertEquals(mySetRa.getInstance()[2],"456");
        assertNull(mySetRa.getInstance()[3]);
    }

    @Test
    void addMoreThanTenItemsListGrows(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        mySetRa.add("456");
        mySetRa.add("789");
        mySetRa.add("abc");
        mySetRa.add("def");
        mySetRa.add("yyy");
        mySetRa.add("zzz");
        mySetRa.add("xxx");
        mySetRa.add("ttt");
        mySetRa.add("sdaf");
        // 10

        mySetRa.add("fhgfdf");
        mySetRa.add("hello kittay");
        mySetRa.add("fsa");
        mySetRa.add("fgsfd");
        // 14

        assertEquals(14,mySetRa.size());

        mySetRa.delete("hello kittay");
        mySetRa.delete("fgsfd");

        assertEquals(12,mySetRa.size());
    }

    @Test
    void addMoreThanTenItemsListGrowsAndCanAddAgain(){
        MySetRa mySetRa = new MySetRa();
        mySetRa.add("123");
        mySetRa.add("456");
        mySetRa.add("789");
        mySetRa.add("abc");
        mySetRa.add("def");
        mySetRa.add("yyy");
        mySetRa.add("zzz");
        mySetRa.add("xxx");
        mySetRa.add("ttt");
        mySetRa.add("sdaf");
        // 10

        mySetRa.add("fhgfdf");
        mySetRa.add("hello kittay");
        mySetRa.add("fsa");
        mySetRa.add("fgsfd");
        // 14

        assertEquals(14,mySetRa.size());

        mySetRa.delete("hello kittay");
        mySetRa.delete("fgsfd");

        assertEquals(12,mySetRa.size());

        mySetRa.add("yufiysa");
        mySetRa.add("hello kootey");

        assertEquals(14,mySetRa.size());

        assertEquals(
                "{ 123, 456, 789, abc, def, yyy, zzz, xxx, ttt, sdaf, fhgfdf, fsa, yufiysa, hello kootey }",
                mySetRa.toString()
        );
    }

}
