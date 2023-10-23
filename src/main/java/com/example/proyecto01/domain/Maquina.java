package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

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

    //Constructores
    public Maquina(){}
    public Maquina(Long id2, String img2, String ubicacion2){
        this.id = id2;
        this.img = img2;
        this.ubicacion = ubicacion2;
    }

    //getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public String getUbicacion(){ return ubicacion; }

    //setters
    public void setId(Long id2){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setUbicacion(String ubicacion){ this.ubicacion = ubicacion; }

}
