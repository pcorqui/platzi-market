package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity //Para indicar que es una entidad de la DB
@Table(name = "productos") //para indicar con que tabla esta relacionada en caso de que tuviera el mismo nombre no seria necesario indicar el nomrbre
public class Producto {

    @Id //indica que este campo es el id primario
    @GeneratedValue(strategy = GenerationType.IDENTITY)//indicia que debera generar id en secuencia de manera automatica la estraategia indica el valor de identidad
    @Column(name = "id_producto") //indica a que columna estara relacionada si tuviera el mismo nombre que la culumna lo paea en automatico
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String Codigobarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //La primera anotacion es de muchos a uno referenciando la tabla categoria
    //la segunda anotacion se refiere al atributo con quien esta vinculado en la db la tabla producto
    // es decir la Producto tiene una relacion muchos a uno con la tabla categoria
    //los dos atributos insertable and updatable significa que no podremos insertar
    //ningun categoria desde este clase, lo que significa que solo nos servira para
    //recuperar a que categoria pertenece un producto
    @ManyToOne
    @JoinColumn(name = "id_categoria",insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigobarras() {
        return Codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        Codigobarras = codigobarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double pecioVenta) {
        this.precioVenta = pecioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
