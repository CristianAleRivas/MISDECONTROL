package com.misde.proveedores;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProveedoresRepository implements PanacheRepository<ProveedoresEntity> {

    @Inject EntityManager em;
    
    @Transactional
    public ProveedoresEntity guardarProveedor(String nombre, String contacto, String descripcion) {
        ProveedoresEntity proveedor = new ProveedoresEntity(nombre, contacto, descripcion);
        persist(proveedor);
        return proveedor;
    }

    public List<ProveedoresEntity> listarProveedores() {
        return em.createQuery("SELECT p FROM ProveedoresEntity p", ProveedoresEntity.class).getResultList();
    }
}
