package com.misde.tipoMovimientos;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TpmovimientosRepository implements PanacheRepository<TpmovimientosEntity> {
}