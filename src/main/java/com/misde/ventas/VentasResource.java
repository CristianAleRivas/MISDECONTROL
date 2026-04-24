package com.misde.ventas;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path; 

@Path("/ventas")
public class VentasResource{

    @Inject
    VentasRepository repo;

    @GET
    public List<VentasEntity> listar(){
        return repo.listAll();
    }
}