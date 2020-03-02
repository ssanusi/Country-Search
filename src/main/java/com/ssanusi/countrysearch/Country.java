package com.ssanusi.countrysearch;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter  = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landMassSize;
    private int medianAge;

    public int getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public Country(String name, int population, int landMassSize, int median) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.medianAge = median;
        this.landMassSize = landMassSize;
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

    public long getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getMedian() {
        return medianAge;
    }

    public void setMedian(int median) {
        this.medianAge = median;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landMassSize=" + landMassSize +
                ", median=" + medianAge +
                '}';
    }
}
