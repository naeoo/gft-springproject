package dio.gft.clientes.service.impl;

import dio.gft.clientes.model.Fornecedor;
import dio.gft.clientes.model.FornecedorRepository;
import dio.gft.clientes.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public Iterable<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.get();
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
    fornecedorRepository.save(fornecedor);
    }

    @Override
    public void atualizar(Long id, Fornecedor fornecedor) {
    Optional<Fornecedor> fornecedorBd = fornecedorRepository.findById(id);
    if(fornecedorBd.isPresent()) {
        fornecedorRepository.save(fornecedor);
    }
    }

    @Override
    public void deletar(Long id) {
    fornecedorRepository.deleteById(id);
    }
}
