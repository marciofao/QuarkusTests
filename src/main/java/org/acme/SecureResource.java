package org.acme;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

@Path( "secure")
@RequestScoped
public class SecureResource {

    @Claim(standard = Claims.preferred_username)
    private String username;

    @GET
    @Path("claim")
    @RolesAllowed( "Subscriber")
    public String getClaim() {
        return username;
    }
}

/*
 Usage in PS:

 $token = Invoke-RestMethod -Uri "https://raw.githubusercontent.com/eldermoraes/unipds/main/jwt-token/quarkus.jwt.token"

 Invoke-WebRequest -Uri "http://localhost:8080/api/secure/claim" `
    -Headers @{ Authorization = "Bearer $token" } `
    -Method Get


    use Jaeger for tests:
    docker run --name=jaeger -d -p 16686:16686 -p 4317:4317 -e COLLECTOR-OTLP-ENABLED=true jaegertracing/all-in-one:latest
* */
