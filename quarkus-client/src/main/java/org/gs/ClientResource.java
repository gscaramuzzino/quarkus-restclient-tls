package org.gs;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/client")
public class ClientResource {

    @RestClient
    @Inject
    Client client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return client.call();
    }
}