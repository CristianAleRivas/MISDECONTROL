package com.misde.proveedores;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedoresResource {

    @Inject
    ProveedoresRepository repo;

    @GET
    public List<ProveedoresEntity> listar() {
        return repo.listarProveedores();
    }

    @POST
    public ProveedoresEntity guardar(GuardarProveedorDTO dto) {
        return repo.guardarProveedor(dto.nombre(), dto.contacto(), dto.descripcion());
    }
}
