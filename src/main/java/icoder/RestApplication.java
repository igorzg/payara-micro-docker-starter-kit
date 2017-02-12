package icoder;

import icoder.helpers.Config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Application initialization
 *
 * @since 1.0
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    public RestApplication() {
        super();
        // load properties
        try {
            Config.load("config.properties", this.getClass().getClassLoader());
            Config.load("release.properties", this.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}