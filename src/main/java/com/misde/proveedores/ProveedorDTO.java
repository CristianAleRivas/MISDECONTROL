package com.misde.proveedores;

public record ProveedorDTO(
    Long id,
    String nombre,
    String contacto,
    String descripcion
) {
}
