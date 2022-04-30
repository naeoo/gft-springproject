package dio.gft.clientes.controller;

import dio.gft.clientes.model.Fornecedor;
import dio.gft.clientes.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fornecedor")
public class FornecedorRestController {

    @Autowired
    private FornecedorService fornecedorService;


    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> buscarTodos() {
        return ResponseEntity.ok(fornecedorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorID(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Fornecedor> inserir(@RequestBody Fornecedor fornecedor) {
        fornecedorService.inserir(fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id , @RequestBody Fornecedor fornecedor){
        fornecedorService.atualizar(id, fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fornecedor> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

