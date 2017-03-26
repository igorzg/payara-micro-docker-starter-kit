import icoder.RestApplication;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Integration
 *
 * @since 1.0
 */
@RunWith(Arquillian.class)
public class StatusResourceIntegrationTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "integration-test.war")
                .addPackages(true, RestApplication.class.getPackage().getName())
                .addAsWebInfResource("beans.xml")
                .addAsResource("log4j2.xml")
                .addAsResource("config.properties");
    }

    @Test
    public void checkStatus(@ArquillianResource URL baseURL) throws Exception {
        Response result = ClientBuilder.newClient().target(baseURL.toURI()).request().get();
        assertThat(result.getStatus(), is(200));
    }

}
