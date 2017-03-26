package icoder;

import icoder.features.JacksonFeature;
import org.reflections.Reflections;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Application initialization
 *
 * @since 1.0
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    private List<Class<?>> getTypesAnnotatedWith(String packageName, Class<? extends Annotation> type) {
        return new Reflections(packageName)
                .getTypesAnnotatedWith(type)
                .stream()
                .collect(Collectors.toList());
    }


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        String PACKAGE_NAME = RestApplication.class.getPackage().getName();
        resources.addAll(getTypesAnnotatedWith(PACKAGE_NAME, Path.class));
        resources.addAll(getTypesAnnotatedWith(PACKAGE_NAME, Provider.class));
        resources.add(JacksonFeature.class);
        return resources;
    }
}