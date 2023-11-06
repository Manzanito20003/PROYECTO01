package com.example.proyecto01.Service;

import com.example.proyecto01.domain.Cliente;
import com.example.proyecto01.domain.Compra;

import com.example.proyecto01.infrastracture.CompraRepository;
import com.example.proyecto01.infrastracture.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CompraRepository compraRepository;

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
            existingCliente.setCompras(cliente.getCompras());

            clienteRepository.save(existingCliente);
        }
        return optionalCliente;
    }

    public Optional<Cliente> patchCliente(Long id,Cliente cliente) {
        Optional<Cliente> OptionalCliente = clienteRepository.findById(id);
        if (OptionalCliente.isPresent()) {
            Cliente existingCliente = OptionalCliente.get();
            if (cliente.getUserName() != null) {
                existingCliente.setUserName(cliente.getUserName());
            }
            if (cliente.getEmail() != null) {
                existingCliente.setEmail(cliente.getEmail());
            }
            if (cliente.getContrasena() != null) {
                existingCliente.setContrasena(cliente.getContrasena());
            }
            if (cliente.getCantidad_compras() != null) {
                existingCliente.setCantidad_compras(cliente.getCantidad_compras());
            }
            if (cliente.getDireccion() != null) {
                existingCliente.setDireccion(cliente.getDireccion());
            }
            if (cliente.getCompras() != null){
                existingCliente.setCompras(cliente.getCompras());
            }

            clienteRepository.save(existingCliente);
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

    public void realizarCompra(Long id, Compra compra) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
                NoSuchElementException("No se encontró el cliente con ID: " + id));
        List<Compra> compras = cliente.getCompras();
        compras.add(compra);
        cliente.setCompras(compras);

        compraRepository.save(compra);
        clienteRepository.save(cliente);
    }

}