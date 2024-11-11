package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.PedidoProdutoDTO;
import br.com.einsteinlimeira.service.PedidoProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("pedidoproduto")
public class PedidoProdutoController {

    @Autowired
    private PedidoProdutoService pedidoProdutoService;

    @GetMapping
    public ResponseEntity<List<PedidoProdutoDTO>> getAll() {
        return ResponseEntity.ok(pedidoProdutoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProdutoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoProdutoService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> save(@RequestBody @Valid PedidoProdutoDTO pedidoProdutoDTO) {
        return ResponseEntity.ok(pedidoProdutoService.save(pedidoProdutoDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> update(@PathVariable Integer id, @RequestBody @Valid PedidoProdutoDTO pedidoProdutoDTO) {
        return ResponseEntity.ok(pedidoProdutoService.update(id, pedidoProdutoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoProdutoService.delete(id));
    }
}