package com.exercise.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by sysdeva5 on 12/10/2016.
 */

@Path("/photo-album")
@Produces(MediaType.APPLICATION_JSON)
public class PhotoResource {

    private Client client;

    public PhotoResource(Client client) {
        this.client = client;
    }

    @GET
    public List getImages() {
        
        return null;
    }
}