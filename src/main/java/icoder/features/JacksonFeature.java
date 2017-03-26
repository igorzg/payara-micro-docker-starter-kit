package icoder.features;

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * Jackson feature
 *
 * @since 1.1
 */
public class JacksonFeature implements Feature {
    private static final String JSON_FEATURE = JacksonFeature.class.getSimpleName();

    public JacksonFeature() {
    }

    static String getPropertyNameForRuntime(String key, RuntimeType runtimeType) {
        if (runtimeType != null && key.startsWith("jersey.config")) {
            RuntimeType[] types = RuntimeType.values();
            for (int i = 0; i < types.length; ++i) {
                RuntimeType type = types[i];
                if (key.startsWith("jersey.config." + type.name().toLowerCase())) {
                    return key;
                }
            }
            return key.replace("jersey.config", "jersey.config." + runtimeType.name().toLowerCase());
        } else {
            return key;
        }
    }

    public boolean configure(FeatureContext context) {
        context.property("jersey.config.server.disableMoxyJson", Boolean.valueOf(true));
        Configuration config = context.getConfiguration();
        context.property(getPropertyNameForRuntime("jersey.config.jsonFeature", config.getRuntimeType()), JSON_FEATURE);
        if (!config.isRegistered(JacksonJaxbJsonProvider.class)) {
            context.register(JsonParseExceptionMapper.class);
            context.register(JsonMappingExceptionMapper.class);
            context.register(JacksonJaxbJsonProvider.class, new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
        }

        return true;
    }
}