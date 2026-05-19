package com.misde.ventas;

import java.time.LocalDate;

public record GuardarVentaDTO(
    LocalDate fecha,
    Double total
) {
}
