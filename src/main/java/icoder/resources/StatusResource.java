package icoder.resources;

import icoder.config.Config;
import icoder.config.IConfig;
import icoder.models.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Micro service status info
 *
 * @since 1.0
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {

    @Inject
    @IConfig
    Config config;

    @GET
    public Service status() {
        Service service = new Service();
        service.setMessage("Service is up and running");
        service.setName(config.toString("applicationName"));
        service.setVersion(config.toString("version") + ":" + config.toString("environment"));
        return service;
    }

}