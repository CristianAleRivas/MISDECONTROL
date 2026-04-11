package com.misde;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;



@Path("/compras")
public class ComprasResource {

    @Inject
    ComprasRepository repo;

    @GET
    public List<ComprasEntity> listar() {
        return repo.listAll();
    }
}
