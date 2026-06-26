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
    @Consumes(MediaType.TEXT_PLAIN)
    public void setI(String value){
        this.i = Integer.parseInt(value);
    }

    @DELETE
    public void deleteI(){
        this.i--;
    }
}
