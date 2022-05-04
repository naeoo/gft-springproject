package dio.gft.springproject.service.impl;

import dio.gft.springproject.model.*;
import dio.gft.springproject.service.FornecedorService;
import dio.gft.springproject.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

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
    salvarFornecedorComCep(fornecedor);
    }

    @Override
    public void atualizar(Long id, Fornecedor fornecedor) {
    Optional<Fornecedor> fornecedorBd = fornecedorRepository.findById(id);
    if(fornecedorBd.isPresent()) {
        salvarFornecedorComCep(fornecedor);
    }
    }

    @Override
    public void deletar(Long id) {
    fornecedorRepository.deleteById(id);
    }

    private void salvarFornecedorComCep(Fornecedor fornecedor) {
        String cep = fornecedor.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        fornecedor.setEndereco(endereco);
        fornecedorRepository.save(fornecedor);
    }
}
