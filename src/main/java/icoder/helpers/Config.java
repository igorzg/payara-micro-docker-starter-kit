package icoder.helpers;

import com.google.common.base.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config loader
 *
 * @since 2.2
 */
public class Config {

    private static Properties properties = new Properties();

    /**
     * Check if is development
     *
     * @return String
     */
    public static boolean isDevelopment() {
        String env = toString("environment");
        if (Strings.isNullOrEmpty(env)) {
            throw new RuntimeException("Configuration file is not loaded!");
        }
        return env.equals("development");
    }

    /**
     * Check if is staging
     *
     * @return String
     */
    public static boolean isStaging() {
        String env = toString("environment");
        if (Strings.isNullOrEmpty(env)) {
            throw new RuntimeException("Configuration file is not loaded!");
        }
        return env.equals("staging");
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isTest() {
        String env = toString("environment");
        if (Strings.isNullOrEmpty(env)) {
            throw new RuntimeException("Configuration file is not loaded!");
        }
        return env.equals("test");
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isProduction() {
        String env = toString("environment");
        if (Strings.isNullOrEmpty(env)) {
            throw new RuntimeException("Configuration file is not loaded!");
        }
        return env.equals("production");
    }

    /**
     * @param name String
     * @return String
     */
    public static Integer toInt(String name) {
        return Integer.parseInt(toString(name));
    }

    /**
     * @param name String
     * @return String
     */
    public static String toString(String name, String def) {
        return properties.containsKey(name) ? properties.getProperty(name) : def;
    }

    /**
     * @param name String
     * @return String
     */
    public static String toString(String name) {
        return properties.getProperty(name);
    }

    /**
     * Load config file as Properties
     *
     * @param fileName    String
     * @param classLoader ClassLoader
     * @return Properties
     * @throws IOException
     */
    public static Properties load(String fileName, ClassLoader classLoader) throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        properties.load(inputStream);
        return properties;
    }

    /**
     * Load config file as Properties
     *
     * @param fileName String
     * @return Properties
     * @throws IOException
     */
    public static Properties load(String fileName) throws IOException {
        InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(fileName);
        properties.load(inputStream);
        return properties;
    }
}