package unit;

import icoder.helpers.Config;
import icoder.models.Service;
import icoder.resources.StatusResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusResourceTest {

    @InjectMocks
    StatusResource statusResource;

    @Test
    public void t1Status() {
        Service service = new Service();
        service.setMessage("Service is up and running");
        service.setName("starter");
        service.setVersion(Config.toString("version") + ":" + Config.toString("environment"));
        assertEquals(statusResource.status(), service);
    }
}
