package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
@Table(name = "producto")
public class Producto {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)

    //llave primaria
    private Long id;
    private String img;
    private Long stock;
    private Float precio;
    private String descripcion;
    private Boolean estado; //booleano para convertir el "v" en disponible y el "f"  en agotado

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquina maquina;


    //Constructores
    public Producto(){}
    public Producto(Long id2, String img2, Long stock2, Float precio2, String descripcion2, Boolean estado2){
        this.id =  id2;
        this.img = img2;
        this.stock = stock2;
        this.precio = precio2;
        this.descripcion = descripcion2;
        this.estado = estado2;
    }


    //Getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public Long getStock(){ return stock; }
    public Float getPrecio(){ return precio; }
    public String getDescripcion(){ return descripcion; }
    public Boolean getEstado(){ return estado; }

    //Setters
    public void setId(Long id){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setStock(Long stock){ this.stock = stock; }
    public void setPrecio(Float precio){ this.precio = precio; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    public void setEstado(Boolean estado){ this.estado = estado; }


}
