package com.example.proyecto01.Service;

import com.example.proyecto01.domain.Cliente;
import com.example.proyecto01.domain.Compra;
import com.example.proyecto01.domain.Maquina;
import com.example.proyecto01.application.MaquinaController;
import com.example.proyecto01.domain.Producto;
import com.example.proyecto01.infrastracture.MaquinaRepository;
import com.example.proyecto01.infrastracture.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class MaquinaService {
    @Autowired
    public MaquinaRepository maquinaRepository;
    @Autowired
    public ProductoRepository productoRepository;

    public List<Maquina> getAllMaquina() { return maquinaRepository.findAll(); }

    public Maquina saveMaquina(Maquina maquina){ return maquinaRepository.save(maquina); }

    public Optional<Maquina> updateMaquina(Long id, Maquina maquina){
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if(optionalMaquina.isPresent()){
            Maquina eixstingMaquina = optionalMaquina.get();
            eixstingMaquina.setUbicacion(maquina.getUbicacion());
            eixstingMaquina.setImg(maquina.getImg());
            eixstingMaquina.setInventario(maquina.getInventario());
            eixstingMaquina.setTipo(maquina.getTipo());
            maquinaRepository.save(eixstingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> patchMaquina(Long id,Maquina maquina) {
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if (optionalMaquina.isPresent()) {
            Maquina existingMaquina = optionalMaquina.get();
            if (maquina.getUbicacion() != null) {
                existingMaquina.setUbicacion(maquina.getUbicacion());
            }
            if (maquina.getImg() != null) {
                existingMaquina.setImg(maquina.getImg());
            }
            if(maquina.getInventario() != null){
                existingMaquina.setInventario(maquina.getInventario());
            }
            if(maquina.getTipo() != null){
                existingMaquina.setTipo(maquina.getTipo());
            }
            maquinaRepository.save(existingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> deleteMaquina(Long id) {
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if (optionalMaquina.isPresent()) {
            Maquina existingMaquina = optionalMaquina.get();
            maquinaRepository.delete(existingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> getMaquina(Long id) {
        return maquinaRepository.findById(id);
    }

    public void InventarioMaquina(Long id, Producto producto) {
        Maquina maquina = maquinaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontró el cliente con ID: " + id));
        List<Producto> productos = maquina.getInventario();
        productos.add(producto);
        maquina.setInventario(productos);

        productoRepository.save(producto);
        maquinaRepository.save(maquina);
    }
}
