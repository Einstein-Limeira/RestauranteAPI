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
    public ResponseEntity<List<PedidoProdutoDTO>> getAllProductsOrders() {
        return ResponseEntity.ok(pedidoProdutoService.findAllProductsOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProdutoDTO> getProductOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoProdutoService.findProductOrderById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> saveProductOrder(@RequestBody @Valid PedidoProdutoDTO pedidoProdutoDTO) {
        return ResponseEntity.ok(pedidoProdutoService.saveProductOrder(pedidoProdutoDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> updateProductOrder(@PathVariable Integer id, @RequestBody @Valid PedidoProdutoDTO pedidoProdutoDTO) {
        return ResponseEntity.ok(pedidoProdutoService.updateProductOrder(id, pedidoProdutoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoProdutoDTO> deleteProductOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoProdutoService.deleteProductOrder(id));
    }
}