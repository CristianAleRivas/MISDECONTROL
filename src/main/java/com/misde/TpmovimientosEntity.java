package com.misde;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "TPOMOVIMIENTOS")
public class TpmovimientosEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTPOMOVIMIENTO")
    private Long id;

    @Column(name = "TPOMOVIMIENTO")
    private String tpmovimiento;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public TpmovimientosEntity() {
    }

    public TpmovimientosEntity(String tpmovimiento, String descripcion) {
        this.tpmovimiento = tpmovimiento;
        this.descripcion = descripcion;
    }

    public String getTipoMovimiento() {
        return tpmovimiento;
    }

    public void setTipoMovimiento(String tpmovimiento) {
        this.tpmovimiento = tpmovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
