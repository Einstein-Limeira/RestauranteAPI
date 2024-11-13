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
    public ResponseEntity<List<SituacaoCadastroDTO>> getAllAccountsStatus() {
        return ResponseEntity.ok(situacaoCadastroService.findAllAccountsStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoCadastroDTO> getAccountStatusById(@PathVariable Integer id) {
        return ResponseEntity.ok(situacaoCadastroService.findAccountStatusById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> saveAccountStatus(@RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        return ResponseEntity.ok(situacaoCadastroService.saveAccountStatus(situacaoCadastroDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> updateAccountStatus(@PathVariable Integer id, @RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        return ResponseEntity.ok(situacaoCadastroService.updateAccountStatus(id, situacaoCadastroDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<SituacaoCadastroDTO> deleteAccountStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(situacaoCadastroService.deleteAccountStatus(id));
    }
}