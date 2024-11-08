package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.SituacaoCadastroDTO;
import br.com.einsteinlimeira.service.SituacaoCadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/situacaocadastro")
public class SituacaoCadastroController {

    @Autowired
    private SituacaoCadastroService situacaoCadastroService;

    @GetMapping
    public List<SituacaoCadastroDTO> getAll() {
        return situacaoCadastroService.getAll();
    }

    @GetMapping("/{id}")
    public SituacaoCadastroDTO getById(@PathVariable Integer id) {
        return situacaoCadastroService.getById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> save(@RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        return ResponseEntity.ok(situacaoCadastroService.save(situacaoCadastroDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> update(@PathVariable Integer id, @RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        return ResponseEntity.ok(situacaoCadastroService.update(id, situacaoCadastroDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(situacaoCadastroService.delete(id));
    }
}