package com.waracle.services.cakemgr.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CakeEntity {

    // @Id annotation specifies the primary key of an entity.
    // @GeneratedValue provides the generation strategy
    // specification for the primary key values.
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String image;


    public CakeEntity(int id, String title, String description, String image){
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public CakeEntity(String title,
                      String desc,
                      String image){
        this.title = title;
        this.description = desc;
        this.image = image;
    }

    public CakeEntity(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CakeEntity that = (CakeEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image);
    }

    @Override
    public String toString() {
        return "CakeEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
