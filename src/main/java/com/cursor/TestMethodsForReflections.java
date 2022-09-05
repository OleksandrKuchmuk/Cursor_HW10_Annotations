package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMethodsForReflections {
    public static final Logger LOGGER = LogManager.getLogger(TestMethodsForReflections.class);

    public void printMessageToConsole(){
        LOGGER.info("This is first method without parameters");
    }

    public void printInputMessage(String message){
        LOGGER.info("Print some text from argument String: \n"+ message);
    }

    public String[] splitString(String message){
        String[] words = message.split(" ");
        return words;
    }

    public int method3(int a, int b, int c){
        return (a+b)*c;
    }


    public void myMethod(String a, int ... args){
        String sub = a.substring(args[0], args[1]);
        LOGGER.info("String at the exit: \n"+sub);

    }

    public void myMethod(String ... args){
        LOGGER.info(String.join(" ", args));
    }
}
