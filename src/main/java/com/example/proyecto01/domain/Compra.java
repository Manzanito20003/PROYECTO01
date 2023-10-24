package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra extends Cliente {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)


    //llave primaria
    private Long id;
    private Date fecha_compra;
    private Float monto_Total;
    private String metodo_de_pago;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;

    //Constructores
    public Compra(){}
    public Compra(Long id2, Date fecha_compra2, Float Monto_Total2, String metodo_de_pago2){
        this.id = id2;
        this.fecha_compra = fecha_compra2;
        this.monto_Total = Monto_Total2;
        this.metodo_de_pago = metodo_de_pago2;
    }

    //getters
    public Long getId(){ return id; }
    public Date getFecha_compra(){ return fecha_compra; }
    public Float getMonto_Total(){ return monto_Total; }
    public String getMetodo_de_pago(){ return metodo_de_pago; }

    //setters
    public void setId(Long id){ this.id = id; }
    public void setFecha_compra(Date fecha_compra){ this.fecha_compra = fecha_compra; }
    public void setMonto_Total(Float Monto_Total){ this.monto_Total = Monto_Total; }
    public void setMetodo_de_pago(String metodo_de_pago){ this.metodo_de_pago = metodo_de_pago; }



}

