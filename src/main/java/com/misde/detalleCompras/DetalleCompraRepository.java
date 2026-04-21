package com.misde.detalleCompras;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DetalleCompraRepository implements PanacheRepository<DetalleCompraEntity> {
    
}
