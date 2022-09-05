package com.cursor;

import org.apache.logging.log4j.core.util.IOUtils;

import java.io.*;
import java.util.Objects;

public class FileReader {
    public String readFile(String fileName){
        String path = System.getProperty("user.dir")+"/src/main/resources/" + fileName;
        String result = "";
        try{
            InputStream is = new FileInputStream(path);
            Reader reader = new InputStreamReader(Objects.requireNonNull(is));
            result = IOUtils.toString(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
