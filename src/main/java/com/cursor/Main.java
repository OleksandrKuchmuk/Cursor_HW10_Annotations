package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(com.cursor.Main.class);
    private static Person person;

    public static void main(String[] args) {

        // Task 1
        LOGGER.info("\nFields from Person with annotation @Show:\n");
        Person person = new Person("Alex", 40, false, "Ukraine", "Lviv", "Ukraine will win");
        Service service = new Service();
        service.printFieldsWithAnnotations(person, person.getClass());

        //Task 2
        LOGGER.info("\nValue from Annotation in Person Fields:\n");
        service.printAnnotationValueInConsole(person.getClass());




    }
}