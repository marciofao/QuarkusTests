package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("starwars")
@Produces("application/json")
public class StarWarsResource {

    @RestClient
    StarWarsService starWarsService;
    @GET
    @Path("starships")
    public String getStarShips(){
        return starWarsService.getStarships();
    }
}
