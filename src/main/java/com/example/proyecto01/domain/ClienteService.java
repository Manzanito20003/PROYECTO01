package com.example.proyecto01.domain;
import com.example.proyecto01.application.ClienteController;
import com.example.proyecto01.infrastracture.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClient() { return clienteRepository.findAll(); }

    public Cliente saveCliente(Cliente cliente){ return clienteRepository.save(cliente); }

    public Optional<Cliente> updateCliente(Long id, Cliente cliente){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setUserName(cliente.getUserName());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setContrasena(cliente.getContrasena());
            existingCliente.setCantidad_compras(cliente.getCantidad_compras());
            existingCliente.setDireccion(cliente.getDireccion());
        }
        return optionalCliente;
    }

    public Optional<Cliente> patchCliente(Long id,Cliente cliente) {
        Optional<Cliente> OptionalCliente = clienteRepository.findById(id);
        if (OptionalCliente.isPresent()) {
            Cliente existingSong = OptionalCliente.get();
            if (cliente.getUserName() != null) {
                existingSong.setUserName(cliente.getUserName());
            }
            if (cliente.getEmail() != null) {
                existingSong.setEmail(cliente.getEmail());
            }
            if (cliente.getContrasena() != null) {
                existingSong.setContrasena(cliente.getContrasena());
            }
            if (cliente.getCantidad_compras() != null) {
                existingSong.setCantidad_compras(cliente.getCantidad_compras());
            }
            if (cliente.getDireccion() != null) {
                existingSong.setDireccion(cliente.getDireccion());
            }
        }
        return OptionalCliente;
    }

    public Optional<Cliente> deleteCliente(Long id) {
        Optional<Cliente> optionalSong = clienteRepository.findById(id);
        if (optionalSong.isPresent()) {
            Cliente existingSong = optionalSong.get();
            clienteRepository.delete(existingSong);
        }
        return optionalSong;
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }


}
