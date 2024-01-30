package com.springgradle.project.persistence.entity;


import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Entity
@Table(name= "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_producto")
    private Integer idProducto;

    @Column (name = "nombre_producto")
    private String nombre;

    @Column(name= "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name= "precio_venta")
    private Double precioVenta;

    @Column(name= "cantidad_stock")
    private Double cantidadStock;

    private Integer estado;


    // Crear realaciones entre tablas - foreign Keys




    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false , updatable = false)
    private Categoria categoria;


    // Getters and Setters


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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Double cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
