package com.misde.ventas;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/ventas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VentasResource {

    @Inject
    VentasRepository repo;

    @GET
    public List<VentasEntity> listar() {
        return repo.listarVentas();

    }

    @POST
    public VentasEntity guardar(GuardarVentaDTO dto) {
        return repo.guardarVenta(dto.total());

    }
}