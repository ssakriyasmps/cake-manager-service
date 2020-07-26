package com.waracle.services.cakemgr.model;

import com.waracle.services.cakemgr.repository.CakeEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CakeEntityTest {


    private static final String title = "ginger cake";
    private static final String desc = "delicious ginger cake";
    private static final String image = "https://xyz/abc/test.gif";


    @Test
    public void testObjectGetters_IdConstructor(){

        CakeEntity cakeEntity = new CakeEntity(1,title, desc, image);

        assertEquals(1, cakeEntity.getId());
        assertEquals(title, cakeEntity.getTitle());
        assertEquals(desc, cakeEntity.getDescription());
        assertEquals(image, cakeEntity.getImage());
    }

    @Test
    public void testObjectGetters_NonIdConstructor(){

        CakeEntity cakeEntity = new CakeEntity(title, desc, image);

        assertEquals(title, cakeEntity.getTitle());
        assertEquals(desc, cakeEntity.getDescription());
        assertEquals(image, cakeEntity.getImage());
    }

    @Test
    public void testObjectsAreEqual(){

        CakeEntity cakeEntity1 = new CakeEntity(title, desc, image);
        CakeEntity cakeEntity2= new CakeEntity(title, desc, image);


        assertTrue(cakeEntity1.equals(cakeEntity2));
    }


    @Test
    public void testEqualObjectsHaveSameHashcode(){

        CakeEntity cakeEntity1 = new CakeEntity(title, desc, image);
        CakeEntity cakeEntity2= new CakeEntity(title, desc, image);

        assertEquals(cakeEntity1.hashCode(), cakeEntity2.hashCode());
    }

    @Test
    public void testObjectIsReflexive(){

        CakeEntity cakeEntity = new CakeEntity(title, desc, image);

        assertTrue(cakeEntity.equals(cakeEntity));
    }

    @Test
    public void testToString(){

        CakeEntity cakeEntity = new CakeEntity(1, title, desc, image);

        String expToString = expectedToString(1, title, desc, image);

        assertEquals(expToString, cakeEntity.toString());
    }

    private String expectedToString(int id, String title, String description, String image){
        return "CakeEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
