package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person {
    public static final Logger LOGGER = LogManager.getLogger(Person.class);

    @Show
    private String name;
    @Show
    private int age;
    private boolean haveAnimals;
    @Show
    private String countryOfLiving;
    private String cityOfLiving;
    @Show
    private String message;

    public Person(String name, int age, boolean haveAnimals, String countryOfLiving, String cityOfLiving, String message) {
        this.name = name;
        this.age = age;
        this.haveAnimals = haveAnimals;
        this.countryOfLiving = countryOfLiving;
        this.cityOfLiving = cityOfLiving;
        this.message = message;
    }
}
