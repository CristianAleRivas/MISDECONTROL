package com.misde.proveedores;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProveedorMapper {

    public ProveedorDTO toDto(ProveedoresEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ProveedorDTO(
            entity.getId(),
            entity.getNombre(),
            entity.getContacto(),
            entity.getDescripcion()
        );
    }

    public List<ProveedorDTO> toDtoList(List<ProveedoresEntity> entities) {
        return entities.stream()
            .map(this::toDto)
            .toList();
    }
}
