package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person {
    public static final Logger LOGGER = LogManager.getLogger(Person.class);

    @Show(name = "from field 'name' with annotation @Show")
    @FieldName(value = "username")
    private String name;

    @Show(name = "from field 'age' with annotation @Show")
    private int age;

    @FieldName(value = "age")
    private String age1;

    @Show(name = "from field 'countryOfLiving' with annotation @Show")
    @FieldName(value = "country")
    private String countryOfLiving;

    @FieldName(value = "city")
    private String cityOfLiving;
    @FieldName(value = "myMessage")
    @Show(name = "from field 'message' with annotation @Show")
    private String message;

    public Person(String name, int age, String age1, String countryOfLiving, String cityOfLiving, String message) {
        this.name = name;
        this.age = age;
        this.age1 = age1;
        this.countryOfLiving = countryOfLiving;
        this.cityOfLiving = cityOfLiving;
        this.message = message;
    }

    public Person(String name, int age, String countryOfLiving, String cityOfLiving, String message) {
        this.name = name;
        this.age = age;
        this.countryOfLiving = countryOfLiving;
        this.cityOfLiving = cityOfLiving;
        this.message = message;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void walk(){
   LOGGER.info("I walk every day in the morning");
}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", countryOfLiving='" + countryOfLiving + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

