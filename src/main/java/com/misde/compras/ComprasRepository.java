package com.misde.compras;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComprasRepository implements PanacheRepository<ComprasEntity> {
    

}

