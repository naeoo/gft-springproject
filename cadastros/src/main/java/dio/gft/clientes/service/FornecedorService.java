package dio.gft.clientes.service;

import dio.gft.clientes.model.Cliente;
import dio.gft.clientes.model.Fornecedor;

/**
 * Interface de padrão do serviço Fornecedor.
 *
 * Define os métodos que devem existir nas classes
 * que a implementarem.
 *
 * @author natanael
 */

public interface FornecedorService {

    Iterable<Fornecedor> buscarTodos();

    Fornecedor buscarPorId(Long id);

    void inserir(Fornecedor fornecedor);

    void atualizar(Long id, Fornecedor fornecedor);

    void deletar(Long id);
}
