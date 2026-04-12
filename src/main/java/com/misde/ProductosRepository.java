package com.misde;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductosRepository implements PanacheRepository<ProductosEntity> {
    

}
