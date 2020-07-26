package com.waracle.services.cakemgr.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CakeTest {

    private static final String title = "ginger cake";
    private static final String desc = "delicious ginger cake";
    private static final String image = "https://xyz/abc/test.gif";

    @Test
    public void testObjectGetters(){

        Cake cake = new Cake(title, desc, image);

        assertEquals(title, cake.getTitle());
        assertEquals(desc, cake.getDesc());
        assertEquals(image, cake.getImage());
    }

    @Test
    public void testObjectsAreEqual(){

        Cake cake1= new Cake(title, desc, image);

        Cake cake2 = new Cake(title, desc, image);

        assertTrue(cake1.equals(cake2));
    }


    @Test
    public void testEqualObjectsHaveSameHashcode(){

        Cake cake1= new Cake(title, desc, image);

        Cake cake2 = new Cake(title, desc, image);

        assertEquals(cake1.hashCode(), cake2.hashCode());
    }

    @Test
    public void testObjectIsReflexive(){

        Cake cake = new Cake(title, desc, image);

        assertTrue(cake.equals(cake));
    }

    @Test
    public void testToString(){

        Cake cake = new Cake(title, desc, image);

        String expToString = expectedToString(title, desc, image);

        assertEquals(expToString, cake.toString());
    }

    private String expectedToString(String title, String desc, String image){
        return "Cake{" +
                "title='" + title + '\'' +
                ", description='" + desc + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
