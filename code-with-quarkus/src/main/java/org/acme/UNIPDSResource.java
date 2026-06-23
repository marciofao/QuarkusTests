package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UNIPDSResource {
    private int i = 0;

    @GET
    public int getI(){
        return i;
    }

    @GET
    @Path("/time")
    public String getTime(){
        return "The time is " + System.currentTimeMillis();
    }

    @POST
    public void addI(){
        this.i++;
    }

    @PUT
    public void setI(int i){
        this.i = i;
    }

    @DELETE
    public void deleteI(){
        this.i--;
    }
}
