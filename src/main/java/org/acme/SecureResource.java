package org.acme;

import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

@Path( "secure")
@RequestScoped
public class SecureResource {

    @Inject
    @Claim(standard = Claims.preferred_username)
    private String username;

    @GET
    @Path("claim")
    @PermitAll
    public String getClaim() {
        return username;
    }
}

/*
* Usage in PS:
*
* $token = Invoke-RestMethod -Uri "https://raw.githubusercontent.com/eldermoraes/unipds/main/jwt-token/quarkus.jwt.token"
*
* Invoke-WebRequest -Uri "http://localhost:8080/api/secure/claim" `
>>     -Headers @{ Authorization = "Bearer $token" } `
>>     -Method Get
* */
