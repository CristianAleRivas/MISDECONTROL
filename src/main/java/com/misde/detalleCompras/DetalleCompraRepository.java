package com.misde.detalleCompras;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class DetalleCompraRepository implements PanacheRepository<DetalleCompraEntity> {
    
    @Inject
    EntityManager em;
    
    public List<DetalleCompraEntity> obtenerDetalleCompra(Long idCompra) {
        return em.createQuery("SELECT d FROM DetalleCompraEntity d WHERE d.compra.id = :idCompra", DetalleCompraEntity.class)
                 .setParameter("idCompra", idCompra)
                 .getResultList();
    }
}
