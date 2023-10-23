package com.example.proyecto01.domain;
import com.example.proyecto01.application.MaquinaController;
import com.example.proyecto01.infrastracture.CompraRepository;
import com.example.proyecto01.infrastracture.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaquinaService {
    @Autowired
    public MaquinaRepository maquinaRepository;
    public List<Maquina> getAllCompra() { return maquinaRepository.findAll(); }

    public Maquina saveCompra(Maquina maquina){ return maquinaRepository.save(maquina); }

    public Optional<Maquina> updateCompra(Long id, Maquina maquina){
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if(optionalMaquina.isPresent()){
            Maquina eixstingMaquina = optionalMaquina.get();
            eixstingMaquina.setUbicacion(maquina.getUbicacion());
            eixstingMaquina.setImg(maquina.getImg());
        }
        return optionalMaquina;
    }

    public Optional<Maquina> patchCompra(Long id,Maquina maquina) {
        Optional<Maquina> optionalCompra = maquinaRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Maquina existingMaquina = optionalCompra.get();
            if (maquina.getUbicacion() != null) {
                existingCompra.setFecha_compra(maquina.getFecha_compra());
            }
            if (maquina.getMetodo_de_pago() != null) {
                existingCompra.setMetodo_de_pago(maquina.getMetodo_de_pago());
            }
            if (maquina.getMonto_Total() != null) {
                existingCompra.setMonto_Total(maquina.getMonto_Total());
            }
        }
        return optionalCompra;
    }

    public Optional<Maquina> deleteCompra(Long id) {
        Optional<Maquina> optionalCompra = maquinaRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Maquina existingCompra = optionalCompra.get();
            maquinaRepository.delete(existingCompra);
        }
        return optionalCompra;
    }

    public Optional<Compra> getCompra(Long id) {
        return maquinaRepository.findById(id);
    }


}
