package com.platzi.market.persistence.entity;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "compras_producto")
public class ComprasProducto {

    @EmbeddedId//este se utiliza cuando la clave primaria es compuesta y id cuando es sencilla
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    //toda relacion que tenga mucho a uno debe llevar los atributos insertable, updatable = false
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable=false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable=false)
    private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
