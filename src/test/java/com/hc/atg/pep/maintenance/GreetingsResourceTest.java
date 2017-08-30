package com.hc.atg.pep.maintenance;

import static org.junit.Assert.assertEquals;


import com.hc.atg.pep.maintenance.controllers.GreetingResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@RunWith(Arquillian.class)
public class GreetingsResourceTest {
    @Deployment()
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(MaintenanceApplication.class, GreetingResource.class);
    }

    private WebTarget target;

    @ArquillianResource
    private URL base;

    @Before
    public void setUpClass() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "root/greetings").toExternalForm()));
    }

    @Test
    public void testGet() {
        String result = target.request().get(String.class);
        assertEquals("hello", result);
    }
}
