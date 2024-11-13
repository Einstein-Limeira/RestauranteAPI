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
    public ResponseEntity<List<PedidoDTO>> getAllOrders() {
        return ResponseEntity.ok(pedidoService.findAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.findOrderById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDTO> saveOrder(@RequestBody @Valid PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.saveOrder(pedidoDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> updateOrder(@PathVariable Integer id, @RequestBody @Valid PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.updateOrder(id, pedidoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> deleteOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.deleteOrder(id));
    }
}