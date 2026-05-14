package com.misde.compras;

import java.time.LocalDate;

import com.misde.proveedores.ProveedoresEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "COMPRAS")
public class ComprasEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCOMPRA")
    public Long id;

    @Column(name = "FECHA")
    public LocalDate fecha;

    @Column(name = "TOTAL")
    public Double total;

    @ManyToOne
    @JoinColumn(name = "IDPROVEEDOR")
    public ProveedoresEntity proveedor;

    public ComprasEntity() {
    }

    public ComprasEntity(LocalDate fecha, Double total, ProveedoresEntity proveedor) {
        this.fecha = fecha;
        this.total = total;
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ProveedoresEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedoresEntity proveedor) {
        this.proveedor = proveedor;
    }
}