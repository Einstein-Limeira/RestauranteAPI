package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.SituacaoCadastroDTO;
import br.com.einsteinlimeira.service.SituacaoCadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(@RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        situacaoCadastroService.save(situacaoCadastroDTO);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid SituacaoCadastroDTO situacaoCadastroDTO) {
        situacaoCadastroService.update(id, situacaoCadastroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        situacaoCadastroService.delete(id);
    }
}