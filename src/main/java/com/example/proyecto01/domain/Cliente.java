package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "cliente")
public class Cliente {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)

    //llave primaria
    private Long id;
    private String username;
    private String email;
    private String contrasena;
    private Long cantidad_compras;//cantidad de compras acumuladas
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "compras_id")
    private List<Compra> compras; //Historial de compras.

    //Constructores
    public Cliente(){}
    public Cliente(Long id2, String username2, String  email2, String contrasena2, Long cantidad_compras2,
                   String direccion2, List<Compra> compras2){
        this.id = id2;
        this.username = username2;
        this.email = email2;
        this.contrasena = contrasena2;
        this.cantidad_compras = cantidad_compras2;
        this.direccion = direccion2;
        this.compras = compras2;
    }

    //getters
    public Long getId() {
        return id;
    }
    public String getContrasena(){ return contrasena; }
    public String getUserName() {
        return username;
    }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
    public Long getCantidad_compras() { return cantidad_compras; }
    public List<Compra> getCompras() { return compras; }
    //setters
    public void setId(Long id) { this.id = id; }
    public void setContrasena(String contrasena){ this.contrasena = contrasena; }
    public void setUserName(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCantidad_compras(Long cantidad_compras) { this.cantidad_compras = cantidad_compras; }
    public void setCompras(List<Compra> compras) { this.compras = compras; }


}
