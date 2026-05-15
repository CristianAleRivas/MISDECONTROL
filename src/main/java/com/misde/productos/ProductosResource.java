package com.misde.productos;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductosResource {

    @Inject
    ProductosRepository repo;

    @GET
    public List<ProductosEntity> listar() {

        return repo.listarProductos();

    }   

    @POST
    public ProductosEntity guardar(GuardarProductoDTO dto) {

        return repo.guardarProducto(
            dto.nombre(), dto.precio(), dto.stock(),dto.descripcion() );
    }
}