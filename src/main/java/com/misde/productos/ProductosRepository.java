package com.misde.productos;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductosRepository implements PanacheRepository<ProductosEntity> {

    @Inject EntityManager em;

    @Transactional
    public ProductosEntity guardarProducto(
        String nombre,
        Double precio,
        Integer stock,
        String descripcion
    ) {

        ProductosEntity producto = new ProductosEntity(nombre,precio,stock,descripcion);
        persist(producto);
        return producto;
    }

    public List<ProductosEntity> listarProductos() {

        return em.createQuery("SELECT p FROM ProductosEntity p",ProductosEntity.class).getResultList();

    }
}
