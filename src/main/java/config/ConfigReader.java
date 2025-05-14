package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Property file not found in the classpath.");
            }
            properties.load(inputStream);
            System.out.println("Property file loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
