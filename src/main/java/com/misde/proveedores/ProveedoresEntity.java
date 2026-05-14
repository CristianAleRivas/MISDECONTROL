package com.misde.proveedores;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROVEEDORES")
public class ProveedoresEntity extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPROVEEDOR")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CONTACTO")
    private String contacto;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public ProveedoresEntity() {
    }

    public ProveedoresEntity(String nombre, String contacto, String descripcion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
