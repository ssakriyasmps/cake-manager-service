package com.waracle.services.cakemgr.canary.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cake{

    // @Id annotation specifies the primary key of an entity.
    // @GeneratedValue provides the generation strategy
    // specification for the primary key values.
    @Id
    @GeneratedValue
    private String title;
    private String description;
    private String image;

    public Cake(String title, String description, String image){
        this.title = title;
        this.description = description;
        this.image = image;
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
        Cake cake = (Cake) o;
        return Objects.equals(title, cake.title) &&
                Objects.equals(description, cake.description) &&
                Objects.equals(image, cake.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, image);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
