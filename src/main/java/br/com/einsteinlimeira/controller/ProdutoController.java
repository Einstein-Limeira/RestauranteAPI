package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.ProdutoDTO;
import br.com.einsteinlimeira.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProducts() {
        return ResponseEntity.ok(produtoService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveProduct(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.saveProduct(produtoDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.updateProduct(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDTO> deleteProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.deleteProduct(id));
    }
}