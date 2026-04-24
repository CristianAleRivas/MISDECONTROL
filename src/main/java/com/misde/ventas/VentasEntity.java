package com.misde.ventas;

import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "VENTAS")
public class VentasEntity extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENTA")
    private long id;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "TOTAL")
    private double total;

    public VentasEntity(){

    }

    public VentasEntity(LocalDate fecha, double total){
        this.fecha = fecha;
        this.total = total;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }
}