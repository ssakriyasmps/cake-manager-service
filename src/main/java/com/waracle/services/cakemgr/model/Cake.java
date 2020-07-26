package com.waracle.services.cakemgr.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Cake{

    private String title;
    private String desc;
    private String image;


    @JsonCreator
    public Cake(@JsonProperty("title")  String title,
                @JsonProperty("desc") String desc,
                @JsonProperty("image")  String image)
    {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
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
                Objects.equals(desc, cake.desc) &&
                Objects.equals(image, cake.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, desc, image);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "title='" + title + '\'' +
                ", description='" + desc + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
