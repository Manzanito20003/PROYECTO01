package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;  // Cambiado "title" a "name" para seguir una convención de nomenclatura más común
    private String apellido;
    private int edad;
    private String direccion;
    private int  cantidad_compras;//cantidad de compras acumuladas

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidad_compras() {
        return cantidad_compras;
    }

    public void setCantidad_compras(int cantidad_compras) {
        this.cantidad_compras = cantidad_compras;
    }
}
