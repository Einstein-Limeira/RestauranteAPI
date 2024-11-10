package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.PedidoDTO;
import br.com.einsteinlimeira.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDTO> save(@RequestBody @Valid PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.save(pedidoDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> update(@PathVariable Integer id, @RequestBody @Valid PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.update(id, pedidoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.delete(id));
    }
}