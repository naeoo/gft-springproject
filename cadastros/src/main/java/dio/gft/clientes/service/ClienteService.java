package dio.gft.clientes.service;

import dio.gft.clientes.model.Cliente;

/**
 * Interface de padrão do serviço Cliente.
 *
 * Define os métodos que devem existir nas classes
 * que a implementarem.
 *
 * @author natanael
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
