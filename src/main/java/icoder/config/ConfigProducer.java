package icoder.config;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Produce config
 *
 * @since 1.0
 */

public class ConfigProducer {

    private static Map<String, Config> configs = new HashMap<>();

    @Produces
    @IConfig
    public Config produce(InjectionPoint injectionPoint) throws IOException {
        Annotated annotated = injectionPoint.getAnnotated();
        IConfig iConfig = annotated.getAnnotation(IConfig.class);
        String key = iConfig.value();
        if (!configs.containsKey(key)) {
            Config config = new Config();
            config.load(key);
            configs.put(key, config);
        }
        return configs.get(key);
    }
}
