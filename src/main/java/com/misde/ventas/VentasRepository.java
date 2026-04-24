package com.misde.ventas;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VentasRepository implements PanacheRepository<VentasEntity>{

}