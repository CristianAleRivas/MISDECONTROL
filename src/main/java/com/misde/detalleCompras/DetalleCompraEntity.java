package com.misde.detalleCompras;
import com.misde.compras.ComprasEntity;
import com.misde.productos.ProductosEntity;

import jakarta.persistence.*;


@Entity
@Table(name = "DETALLECOMPRAS")
public class DetalleCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDETACOMPRA")
    private Long idDetalleCompra;

    @ManyToOne
    @JoinColumn(name = "IDCOMPRA", nullable = false)
    private ComprasEntity compra;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCTO", nullable = false)
    private ProductosEntity producto;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "TOTAL")
    private Double total;

    public DetalleCompraEntity() {
    }

    public DetalleCompraEntity(ComprasEntity compra, ProductosEntity producto, Double precio, Integer cantidad, Double total) {
        this.compra = compra;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    
    public Long getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Long idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public ComprasEntity getCompra() {
        return compra;
    }

    public void setCompra(ComprasEntity compra) {
        this.compra = compra;
    }

    public ProductosEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductosEntity producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}