package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @Column(name = "img", length = 600)
    private String img;
    private String ubicacion;
    private String tipo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //se declaro ManyToMany para que VARIAS maquinas compartan el mismo producto.
    @JoinColumn(name = "maquina_id")
    private List<Producto> inventario;

    //Constructores
    public Maquina(){}
    public Maquina(Long id2, String img2, String ubicacion2, List<Producto> inventario2, String tipo2){
        this.id = id2;
        this.img = img2;
        this.ubicacion = ubicacion2;
        this.inventario = inventario2;
        this.tipo = tipo2;
    }

    //getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public String getUbicacion(){ return ubicacion; }
    public List<Producto> getInventario() { return inventario; }

    public String getTipo() { return tipo; }

    //setters
    public void setId(Long id2){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setUbicacion(String ubicacion){ this.ubicacion = ubicacion; }
    public void setInventario(List<Producto> inventario2) { this.inventario = inventario2; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}
