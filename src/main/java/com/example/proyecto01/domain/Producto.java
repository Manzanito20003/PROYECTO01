package com.example.proyecto01.domain;

public class Producto {

    private int stock;
    private int codigo;
    private double precio;

    private String informacion_sanitaria;//puede ser entidad mas adelante xq tiene datos q otros productos no tienen

    private String descripcion;

    public String getInformacion_sanitaria() {
        return informacion_sanitaria;
    }

    public void setInformacion_sanitaria(String informacion_sanitaria) {
        this.informacion_sanitaria = informacion_sanitaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String  img;//imagen del product








    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
