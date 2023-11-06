package com.example.proyecto01.domain;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
@Table (name = "tienda")
public class Tienda {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tienda_id", nullable = false)
    private Long id;
    private String ubicacion;
    private String tipo_tienda; //Con esto me refiero
    //a la tiendaa de cafeteria, listo, vendedores individuales, piso 6, etc.
    //excepto maquinas y ello...
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tienda_id")
    private List<Producto> inventarioTienda;

    //constructores
    public Tienda(){}
    public Tienda(Long id, String ubicacion, String tipo_tienda, List<Producto> inventarioTienda) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.tipo_tienda = tipo_tienda;
        this.inventarioTienda = inventarioTienda;
    }

    //getter
    public Long getId() { return id; }
    public String getUbicacion() { return ubicacion; }
    public String getTipo_tienda() { return tipo_tienda; }
    public List<Producto> getInventarioTienda() { return inventarioTienda; }

    //setter
    public void setId(Long id) { this.id = id; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setTipo_tienda(String tipo_tienda) { this.tipo_tienda = tipo_tienda; }
    public void setInventarioTienda(List<Producto> inventarioTienda) { this.inventarioTienda = inventarioTienda; }
}
