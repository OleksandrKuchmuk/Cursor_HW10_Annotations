package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(com.cursor.Main.class);

    public static void main(String[] args) {
        Person person = new Person("Alex", 40, false, "Ukraine", "Lviv", "Ukraine will win");
        Service service = new Service();
        service.print(person, person.getClass());

    }
}