package icoder.config;

import com.google.common.base.Strings;

import javax.enterprise.inject.Default;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config loader
 *
 * @since 2.2
 */
@Default
public class Config {

    private Properties properties = new Properties();

    /**
     * Check if is development
     *
     * @return String
     */
    public boolean isDevelopment() {
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
    public boolean isStaging() {
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
    public boolean isTest() {
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
    public boolean isProduction() {
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
    public Integer toInt(String name) {
        return Integer.parseInt(toString(name));
    }

    /**
     * @param name String
     * @return String
     */
    public String toString(String name, String def) {
        return properties.containsKey(name) ? properties.getProperty(name) : def;
    }

    /**
     * @param name String
     * @return String
     */
    public String toString(String name) {
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
    public Properties load(String fileName, ClassLoader classLoader) throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        properties.load(inputStream);
        return properties;
    }

    /**
     * Clear config
     */
    public void clear() {
        properties.clear();
    }

    /**
     * Load config file as Properties
     *
     * @param value String
     * @return Properties
     * @throws IOException
     */
    public Properties load(String value) throws IOException {
        InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(value);
        properties.load(inputStream);
        return properties;
    }
}