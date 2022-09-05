package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Service {
    public static final Logger LOGGER = LogManager.getLogger(Service.class);
//    private static Class classToCall;
//    private static Method methodToCall;

//    public Service(Class classname) {
//        this.classToCall = classname;
//    }

    public Service() {
    }

    public void printFieldsWithAnnotations(Object o, Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Show.class)) {
                    field.setAccessible(true);
                    try {
                        LOGGER.info("\"" + field.getName() + "\"" + " - " + field.get(o));
                    } catch (IllegalAccessException e) {
                        LOGGER.error("IllegalAccessException in print method");
                    }
                }
            }
        }
    }

    public void printAnnotationValueInConsole(Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            Show show = f.getAnnotation(Show.class);
            if (show != null)
                LOGGER.info("Value from Person field \"" + f.getName() + "\": @Show(name = \"" + show.name() + "\")");
        }
    }

    public void callMethod(Object o, Class c) throws Exception {

        Method method1 = c.getMethod("printMessageToConsole");
        method1.invoke(o);
    }

    public void callMethodWithArgString(Object o, Class c, String message) throws Exception {
        Method method2 = c.getMethod("printInputMessage", java.lang.String.class);
        method2.invoke(o, message);
    }

    public String[] callMethodWithArgStringSplit(Object o, Class c, String message) throws Exception {
        Method method3 = c.getMethod("splitString", java.lang.String.class);
        return (java.lang.String[]) method3.invoke(o, message);

    }

    public int result(Object o, Class cl, int a, int b, int c) throws Exception {
        Method method4 = cl.getMethod("method3", int.class, int.class, int.class);
        return (int) method4.invoke(o, a, b, c);
    }

    public void substring(Object obj, Class cls, String string, int[] intArray) throws Exception {
        Method method = cls.getMethod("myMethod", String.class, int[].class);
        method.invoke(obj, string, intArray);
    }

    public void setAgeField(Object obj, int age) throws IllegalAccessException, NoSuchFieldException {
        Field ageField = obj.getClass().getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(obj, age);
    }

    public void setCityField(Object obj, String city) throws IllegalAccessException, NoSuchFieldException {
        Field cityField = obj.getClass().getDeclaredField("cityOfLiving");
        cityField.setAccessible(true);
        cityField.set(obj, city);

    }

    public void readPersonFromFile() {
        FileReader fileReader = new FileReader();
        String readFromFile = fileReader.readFile("user.txt");
        readFromFile = readFromFile.replace("\r", "");
        String[] stringsToLines = readFromFile.split("\n");
        Person person = new Person();
        Class classPerson = person.getClass();
        Field[] fields = classPerson.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(FieldName.class)) {
                FieldName fieldName = field.getAnnotation(FieldName.class);
                String fieldValue = fieldName.value();
                for (int j = 0; j < stringsToLines.length; j++) {
                    String lineFromFile = stringsToLines[j];
                    String firstPartOfLine = lineFromFile.split("=")[0];
                    if(firstPartOfLine.equals(fieldValue)){
                        field.setAccessible(true);
                        try {
                            field.set(person, lineFromFile.split("=")[1]);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }
        LOGGER.info("the Person class with the fields subtracted from the user.txt file looks like this:\n"+person.toString());

    }
}