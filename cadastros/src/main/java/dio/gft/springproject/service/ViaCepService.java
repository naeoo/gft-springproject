package dio.gft.springproject.service;

import dio.gft.springproject.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Interface de padrão do serviço ViaCep.
 *
 * Define os métodos que devem existir nas classes
 * que a implementarem.
 *
 * @author natanael
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
