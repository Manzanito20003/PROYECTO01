package com.example.proyecto01.Service;
import com.example.proyecto01.domain.Cliente;
import com.example.proyecto01.domain.Compra;
import com.example.proyecto01.application.ClienteController;
import com.example.proyecto01.infrastracture.CompraRepository;
import com.example.proyecto01.infrastracture.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import org.springframework.transaction.annotation.Transactional;

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
            if (cliente.getCompras() != null){
                existingSong.setCompras(cliente.getCompras());
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

    public Cliente obtenerClientePorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }



    @Transactional
    public void realizarCompra(Long clienteId, Compra compra) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new NoSuchElementException("No se encontró el cliente con ID: " + clienteId));
        List<Compra> compras = cliente.getCompras();
        compra.setId(null); // Establece una nueva ID para la compra
        compras.add(compra);
        cliente.setCompras(compras);

        compraRepository.save(compra);
        clienteRepository.save(cliente);
    }
}