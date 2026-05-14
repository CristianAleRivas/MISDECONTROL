package com.misde.detalleCompras;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/detallecompras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DetalleCompraResource {
    
    @Inject
    DetalleCompraRepository repository;

    @GET
    public List<DetalleCompraEntity> listar(@QueryParam("idCompra") Long idCompra) {
        return repository.obtenerDetalleCompra(idCompra);
    }
}
