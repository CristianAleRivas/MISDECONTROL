package com.misde.compras;

import java.time.LocalDate;

import com.misde.proveedores.ProveedoresEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ComprasRepository implements PanacheRepository<ComprasEntity> {

    @Inject EntityManager em;

    @Transactional
    public ComprasEntity guardarCompra(Long idProveedor, Double total) {
        ProveedoresEntity proveedor = em.createQuery("SELECT p FROM ProveedoresEntity p where p.id = :idProveedor", ProveedoresEntity.class)
                                      .setParameter("idProveedor", idProveedor)
                                      .getSingleResult();

        ComprasEntity compra = new ComprasEntity(LocalDate.now(), total, proveedor);
        persist(compra);
        return compra;
    }
}

