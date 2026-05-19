package com.misde.ventas;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VentasRepository implements PanacheRepository<VentasEntity> {

    @Inject EntityManager em;

    @Transactional
    public VentasEntity guardarVenta(Double total) {
        VentasEntity venta = new VentasEntity(LocalDate.now(), total);
        persist(venta);
        return venta;
    }

    public List<VentasEntity> listarVentas() {

        return em.createQuery( "SELECT v FROM VentasEntity v", VentasEntity.class).getResultList();

    }
}