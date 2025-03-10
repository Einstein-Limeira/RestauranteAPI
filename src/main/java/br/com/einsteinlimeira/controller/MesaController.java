package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.MesaDTO;
import br.com.einsteinlimeira.service.MesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<MesaDTO>> getAllTables() {
        return ResponseEntity.ok().body(mesaService.findAllTables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> getTableById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mesaService.findTableById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MesaDTO> saveTable(@RequestBody @Valid MesaDTO mesaDTO) {
        return ResponseEntity.ok().body(mesaService.saveTable(mesaDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<MesaDTO> updateTable(@PathVariable Integer id, @RequestBody @Valid MesaDTO mesaDTO) {
        return ResponseEntity.ok().body(mesaService.updateTable(id, mesaDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MesaDTO> deleteTable(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mesaService.deleteTable(id));
    }
}