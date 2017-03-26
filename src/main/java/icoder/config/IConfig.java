package icoder.config;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Configuration qualifier
 *
 * @since 1.0
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface IConfig {
    String value() default "config.properties";
}
