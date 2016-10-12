package com.exercise.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sysdeva5 on 12/10/2016.
 */

@Path("/photo-album")
@Produces(MediaType.APPLICATION_JSON)
public class PhotoResource {

    @GET
    public List getImages() {

        return null;
    }
}