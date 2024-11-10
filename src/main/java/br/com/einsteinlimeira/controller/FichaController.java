package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.FichaDTO;
import br.com.einsteinlimeira.service.FichaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ficha")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @GetMapping
    public ResponseEntity<List<FichaDTO>> getAll() {
        return ResponseEntity.ok().body(fichaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(fichaService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FichaDTO> save(@RequestBody @Valid FichaDTO fichaDTO) {
        return ResponseEntity.ok().body(fichaService.save(fichaDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<FichaDTO> update(@PathVariable Integer id, @RequestBody @Valid FichaDTO fichaDTO) {
        return ResponseEntity.ok().body(fichaService.update(id, fichaDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<FichaDTO> delete(@PathVariable Integer id) {
        return ResponseEntity.ok().body(fichaService.delete(id));
    }
}