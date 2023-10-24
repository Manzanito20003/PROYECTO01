package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "maquina")
public class Maquina {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)


    //llave primaria
    private Long id;
    private String img;
    private String ubicacion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "productos_id")
    private List<Producto> inventario;

    //Constructores
    public Maquina(){}
    public Maquina(Long id2, String img2, String ubicacion2, List<Producto> inventario2){
        this.id = id2;
        this.img = img2;
        this.ubicacion = ubicacion2;
        this.inventario = inventario2;
    }

    //getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public String getUbicacion(){ return ubicacion; }
    public List<Producto> getInventario() { return inventario; }

    //setters
    public void setId(Long id2){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setUbicacion(String ubicacion){ this.ubicacion = ubicacion; }
    public void setInventario(List<Producto> inventario2) { this.inventario = inventario2; }
}
