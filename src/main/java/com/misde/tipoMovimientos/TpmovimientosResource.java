package com.misde.tipoMovimientos;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/tpmovimientos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TpmovimientosResource {

    @Inject
    TpmovimientosRepository repo;

   
    @GET
    public List<TpmovimientosEntity> listar() {
        return repo.listAll();
    }

   
}