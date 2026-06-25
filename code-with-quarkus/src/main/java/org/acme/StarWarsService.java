package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/asapi/")
public interface StarWarsService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships")
    @Timeout(value = 3000L)
    @Fallback(
            fallbackMethod="getStarshipsFallback"
    )
    String getStarships();

    default String getStarshipsFallback(){
        return "fallback";
    }
}
