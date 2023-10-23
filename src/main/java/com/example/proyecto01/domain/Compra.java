package com.example.proyecto01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)

    private Long id;
    private Date fecha_compra;

    private Long Monto_Total;

    private String metodo_de_pago;

    public Compra(){}

    public Compra(Long id2, Date fecha_compra2, Long Monto_Total2, String metodo_de_pago2){
        this.id = id2;
        this.fecha_compra = fecha_compra2;
        this.Monto_Total = Monto_Total2;
        this.metodo_de_pago = metodo_de_pago2;
    }

    public Long getId(){ return id; }
    public Date getFecha_compra(){ return fecha_compra; }
    public Long getMonto_Total(){ return Monto_Total; }
    public String getMetodo_de_pago(){ return metodo_de_pago; }

    public void setId(Long id){ this.id = id; }
    public void setFecha_compra(Date fecha_compra){ this.fecha_compra = fecha_compra; }
    public void setMonto_Total(Long Monto_Total){ this.Monto_Total = Monto_Total; }
    public void setMetodo_de_pago(String metodo_de_pago){ this.metodo_de_pago = metodo_de_pago; }

}

