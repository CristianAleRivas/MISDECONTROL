package com.misde.compras;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComprasResource {

    @Inject
    ComprasRepository repo;

    @GET
    public List<ComprasEntity> listar() {
        return repo.listAll();
    }

    @POST
    public ComprasEntity guardar(GuardarCompraDTO dto) {
        return repo.guardarCompra(dto.idProveedor(), dto.total());
    }
}
