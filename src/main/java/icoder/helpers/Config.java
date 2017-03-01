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
     * @param name String
     * @return String
     */
    public static Integer toInt(String name) {
        return Integer.parseInt(toString(name));
    }

    /**
     * Check environment
     *
     * @return String
     */
    private static boolean env(String name) {
        String env = toString("environment");
        if (Strings.isNullOrEmpty(env)) {
            throw new RuntimeException("Configuration file is not loaded!");
        }
        return env.equals(name);
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isDevelopment() {
        return env("development");
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isStaging() {
        return env("staging");
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isTest() {
        return env("test");
    }

    /**
     * Check if is production
     *
     * @return String
     */
    public static boolean isProduction() {
        return env("production");
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

    /**
     * Load default config
     *
     * @since 1.1
     */
    public static void loadDefault() {
        try {
            load("config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}