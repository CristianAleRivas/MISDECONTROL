package com.misde.productos;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;



@Path("/productos")
public class ProductosResource {

    @Inject
    ProductosRepository repo;

    @GET
    public List<ProductosEntity> listar() {
        return repo.listAll();
    }
}