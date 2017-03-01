package icoder.features;

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * Enable jackson feature
 * @since 1.0
 */
public class JacksonFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.property( "jersey.config.server.disableMoxyJson", true);

        context.register( JsonParseExceptionMapper.class );
        context.register( JsonMappingExceptionMapper.class );
        context.register( JacksonJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class );
        return true;
    }
}
