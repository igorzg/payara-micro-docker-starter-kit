package icoder.resources;

import icoder.helpers.Config;
import icoder.models.Service;

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

    @GET
    public Service status() {
        Service service = new Service();
        service.setMessage("Service is up and running");
        service.setName("starter");
        service.setVersion(Config.toString("version") + ":" + Config.toString("environment"));
        return service;
    }

}