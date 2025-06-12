package Utilities;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


        private static Properties prop;

        public static String getProp(String propertyName) {
            if (prop == null) {
                try (FileInputStream file = new FileInputStream("C:\\Users\\ragha\\IdeaProjects\\AllConceptsSelenium\\src\\test\\resources\\environment.properties")) {
                    prop = new Properties();
                    prop.load(file);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to load properties file", e);
                }
            }
            return prop.getProperty(propertyName);
        }
    }



