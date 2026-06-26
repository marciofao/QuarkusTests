package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path( "pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    public List<Pessoa> getPessoa(){
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa AddPessoa(Pessoa pessoa){
        pessoa.id = null;
        pessoa.persist();

        return pessoa;
    }
}
