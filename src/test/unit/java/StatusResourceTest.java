import icoder.config.Config;
import icoder.models.Service;
import icoder.resources.StatusResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusResourceTest {


  @Mock
  Config config;

  @InjectMocks
  StatusResource statusResource;

  @Test
  public void t1Status() {
    when(config.toString("applicationName")).thenReturn("starter-kit");
    when(config.toString("version")).thenReturn("1.0.0");
    when(config.toString("environment")).thenReturn("test");

    Service service = new Service();
    service.setMessage("Service is up and running");
    service.setName(config.toString("applicationName"));
    service.setVersion(config.toString("version") + ":" + config.toString("environment"));
    assertEquals(statusResource.status(), service);
  }
}