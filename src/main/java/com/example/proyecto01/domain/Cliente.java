package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)

    private Long id;
    private String UserName;
    private String email;
    private String contrasena;
    private Long cantidad_compras;//cantidad de compras acumuladas
    private String direccion;

    public Cliente(){}
    public Cliente(Long id2, String UserName2, String  email2, String contrasena2, Long cantidad_compras2, String direccion2){
        this.id = id2;
        this.UserName = UserName2;
        this.email = email2;
        this.contrasena = contrasena2;
        this.cantidad_compras = cantidad_compras2;
        this.direccion = direccion2;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContrasena(){ return contrasena; }
    public void setContrasena(String contrasena){ this.contrasena = contrasena; }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Long getCantidad_compras() {
        return cantidad_compras;
    }
    public void setCantidad_compras(Long cantidad_compras) {
        this.cantidad_compras = cantidad_compras;
    }
}
