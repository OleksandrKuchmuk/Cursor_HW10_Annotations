package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(com.cursor.Main.class);

    public static void main(String[] args) throws Exception {

        // Task 1. Create your own annotation. Create class with a few fields, some of
        //which annotate with this annotation. Through reflection print those
        //fields in the class that were annotate by this annotation.

        LOGGER.info("\nFields from Person with annotation @Show:\n");
        Person person = new Person("Alex", 40, "Ukraine", "Lviv", "Ukraine will win");

        Service service = new Service();
        service.printFieldsWithAnnotations(person, person.getClass());

        //Task 2. Print annotation value into console (e.g. @Annotation(name = &quot;111&quot;))
        LOGGER.info("Value from Annotation in Person Fields:");
        service.printAnnotationValueInConsole(person.getClass());


        //Task 3. Invoke method (three method with different parameters and return types)
        LOGGER.info("\nInvoke method (three method with different parameters and return types)\n");

        String message = "Hello, everybody!!! This is the text that will be passed as an argument to the method";
//        TestMethodsForReflections testMethods = new TestMethodsForReflections();
        Class<TestMethodsForReflections> myClass = TestMethodsForReflections.class;
        Object object = new TestMethodsForReflections();

        LOGGER.info("\nCalling method without parameters(the method should print the text that is in it):");
        service.callMethod(object, myClass);

        LOGGER.info("\nCalling method with parameter String(the method should print the text that is in argument String):");
        service.callMethodWithArgString(object, myClass, message);

        LOGGER.info("\nCalling method with parameter String(this method will return an array of words" +
                " from the string passed as an argument): ");
//        Method method3 = myClass.getMethod("splitString", java.lang.String.class);
        String[] splitString = service.callMethodWithArgStringSplit(object, myClass, message);
        System.out.println(Arrays.toString(splitString));


        LOGGER.info("\nCalling method with parameter int(this method calculates ((a+b)*c) the input" +
                " three numbers and returns the result)");
        int result = service.result(object, myClass, 5, 7, 62);
        LOGGER.info("The result from method 4 'result=((a+b)*c)' is: " + result);


        //Task 4. Set value into field using reflection.
        LOGGER.info("Setting value into field using reflection.\n");
        LOGGER.info("Person age before changing: "+person.getAge());
        service.setAgeField(person, 25);
        LOGGER.info("Person age after changing: "+person.getAge()+"\n");

        LOGGER.info("Person age before changing: "+person.getCityOfLiving());
        service.setCityField(person, "Ternopil");
        LOGGER.info("Person age after changing: "+person.getCityOfLiving()+"\n");



        //Task 5. Invoke myMethod(String a, int ... args) and myMethod(String … args).
        String[] newString = new String[]{"This", "is", "a", "test", "string"};
        LOGGER.info("\nCalling method that will receive an array of strings and combine them into one");
        Method myMethod1 = myClass.getMethod("myMethod", String[].class);
        myMethod1.invoke(object, (Object) newString);

        LOGGER.info("\nA string and 2 integers are passed to the method myMethod(String a, int ... args)," +
                " a substring is created \nthat starts with the index = the first number" +
                " and ends with the index = the second number");
        String myMethodString = "This is the string that is passed to the method myMethod(String a, int ... args)";
        LOGGER.info("\nString in its original form: \n"+myMethodString);
        int[] intArray = {5, 48};
        service.substring(object, myClass, myMethodString, intArray);


        //Task 6. Create your own class that received object of unknown type and show information about that Class.
        LOGGER.info("We read the fields from the incoming class (in this case, a file) and show information about it\n");
        service.readPersonFromFile();
    }
}