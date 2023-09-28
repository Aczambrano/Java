/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Anderson
 */
public class Producto {
    
    int id_producto;
    int id_categoria;
    int id_marca;
    String descripcion_producto;
    String precio_producto;
    Date fecha_registro;

    public Producto() {
    }

    public Producto(int id_producto, int id_categoria, int id_marca, String descripcion_producto, String precio_producto, Date fecha_registro) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.fecha_registro = fecha_registro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(String precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
    
}
