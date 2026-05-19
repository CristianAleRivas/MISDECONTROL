package com.misde.proveedores;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedoresResource {

    @Inject
    ProveedorService service;

    @GET
    public List<ProveedorDTO> listar() {
        return service.listarProveedores();
    }

    @GET
    @Path("/{id}")
    public ProveedorDTO obtenerPorId(@PathParam("id") Long id) {
        return service.obtenerProveedorPorId(id);
    }

    @POST
    public Response guardar(GuardarProveedorDTO dto) {
        ProveedorDTO creado = service.guardarProveedor(dto);
        return Response.status(Response.Status.CREATED).entity(creado).build();
    }

    @PUT
    @Path("/{id}")
    public ProveedorDTO actualizar(@PathParam("id") Long id, ActualizarProveedorDTO dto) {
        return service.actualizarProveedor(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        service.eliminarProveedor(id);
        return Response.noContent().build();
    }
}
