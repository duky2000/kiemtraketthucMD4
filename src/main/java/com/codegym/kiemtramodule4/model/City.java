package com.codegym.kiemtramodule4.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "name not null")
    private String name;
    @Positive(message = "số nguyên dương từ 0 trở đi")
    private int area;
    @Positive(message = "số nguyên dương từ 0 trở đi")
    private int population;
    @Positive(message = "số nguyên dương từ 0 trở đi")
    private int GDP;
    @Size(min = 8, max = 300, message = "ít nhất 8 ki tự nhiều nhất 10 kí tự")
    private String introduce;
    @ManyToOne
    private Water water;

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }
}
