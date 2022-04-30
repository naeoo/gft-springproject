package dio.gft.springproject.service.impl;

import dio.gft.springproject.model.Cliente;
import dio.gft.springproject.model.ClienteRepository;
import dio.gft.springproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
    clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> clienteBd = clienteRepository.findById(id);
    if (clienteBd.isPresent()) {
        clienteRepository.save(cliente);
    }
    }

    @Override
    public void deletar(Long id) {
    clienteRepository.deleteById(id);
    }
}
