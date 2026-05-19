package com.misde.proveedores;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProveedorService {
    
    @Inject
    ProveedoresRepository repo;

    @Inject
    ProveedorMapper mapper;

    public ProveedorDTO guardarProveedor(GuardarProveedorDTO dto) {
        validarGuardar(dto);
        ProveedoresEntity entity = repo.guardarProveedor(
            dto.nombre().trim(),
            dto.contacto().trim(),
            dto.descripcion().trim()
        );

        return mapper.toDto(entity);
    }

    public List<ProveedorDTO> listarProveedores() {
        return mapper.toDtoList(repo.listarProveedores());
    }

    public ProveedorDTO obtenerProveedorPorId(Long id) {
        validarId(id);
        ProveedoresEntity entity = repo.obtenerProveedorPorId(id);
        if (entity == null) {
            throw new WebApplicationException(
                "No existe proveedor con id " + id,
                Response.Status.NOT_FOUND
            );
        }

        return mapper.toDto(entity);
    }

    public ProveedorDTO actualizarProveedor(Long id, ActualizarProveedorDTO dto) {
        validarId(id);
        validarActualizacion(dto);

        boolean actualizado = repo.actualizarProveedor(
            id,
            dto.nombre().trim(),
            dto.contacto().trim(),
            dto.descripcion().trim()
        );

        if (!actualizado) {
            throw new WebApplicationException(
                "No existe proveedor con id " + id,
                Response.Status.NOT_FOUND
            );
        }

        ProveedoresEntity entity = repo.obtenerProveedorPorId(id);
        return mapper.toDto(entity);
    }

    public void eliminarProveedor(Long id) {
        validarId(id);
        boolean eliminado = repo.eliminarProveedorPorId(id);
        if (!eliminado) {
            throw new WebApplicationException(
                "No existe proveedor con id " + id,
                Response.Status.NOT_FOUND
            );
        }
    }

    private void validarGuardar(GuardarProveedorDTO dto) {
        if (dto == null) {
            throw new WebApplicationException("El body es obligatorio", Response.Status.BAD_REQUEST);
        }

        validarTexto(dto.nombre(), "nombre");
        validarTexto(dto.contacto(), "contacto");
        validarTexto(dto.descripcion(), "descripcion");
    }

    private void validarActualizacion(ActualizarProveedorDTO dto) {
        if (dto == null) {
            throw new WebApplicationException("El body es obligatorio", Response.Status.BAD_REQUEST);
        }

        validarTexto(dto.nombre(), "nombre");
        validarTexto(dto.contacto(), "contacto");
        validarTexto(dto.descripcion(), "descripcion");
    }

    private void validarId(Long id) {
        if (id == null || id <= 0) {
            throw new WebApplicationException("El id debe ser mayor a 0", Response.Status.BAD_REQUEST);
        }
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new WebApplicationException(
                "El campo " + campo + " es obligatorio",
                Response.Status.BAD_REQUEST
            );
        }
    }
}
