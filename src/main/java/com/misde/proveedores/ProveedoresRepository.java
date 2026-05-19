package com.misde.proveedores;

import java.util.List;
import java.util.Optional;

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
        return em.createNativeQuery("SELECT * FROM PROVEEDORES", ProveedoresEntity.class).getResultList();
    }

    public ProveedoresEntity obtenerProveedorPorId(Long id) {
        Optional<ProveedoresEntity> proveedor = em.createNativeQuery(
                "SELECT * FROM PROVEEDORES WHERE IDPROVEEDOR = :id",
                ProveedoresEntity.class)
            .setParameter("id", id)
            .getResultStream()
            .findFirst();

        return proveedor.orElse(null);
    }

    @Transactional
    public boolean actualizarProveedor(Long id, String nombre, String contacto, String descripcion) {
        int filas = em.createNativeQuery(
                "UPDATE PROVEEDORES SET NOMBRE = :nombre, CONTACTO = :contacto, DESCRIPCION = :descripcion WHERE IDPROVEEDOR = :id")
            .setParameter("nombre", nombre)
            .setParameter("contacto", contacto)
            .setParameter("descripcion", descripcion)
            .setParameter("id", id)
            .executeUpdate();

        return filas > 0;
    }

    @Transactional
    public boolean eliminarProveedorPorId(Long id) {
        int filas = em.createNativeQuery("DELETE FROM PROVEEDORES WHERE IDPROVEEDOR = :id")
            .setParameter("id", id)
            .executeUpdate();

        return filas > 0;
    }
}
