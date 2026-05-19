package com.misde.productos;

public record GuardarProductoDTO(

    String nombre,
    Double precio,
    Integer stock,
    String descripcion

) {
}
