package integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusIntegrationTest {


    private static final Logger LOGGER = LogManager.getLogger(StatusIntegrationTest.class);


    public static String getUrl() {
        return "http://localhost:" + System.getProperty("http.port", "8080");
    }

    @BeforeClass
    public static void beforeClass() {
        LOGGER.debug("RUN TESTS ON: {}", getUrl());
    }

    @Test
    public void status() throws Exception {
        Response result = ClientBuilder.newClient().target(getUrl()).request().get();
        assertThat(result.getStatus(), is(200));
    }


}