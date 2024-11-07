package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.MesaDTO;
import br.com.einsteinlimeira.service.MesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<MesaDTO> findAll() {
        return mesaService.findAll();
    }

    @GetMapping("/{id}")
    public MesaDTO findById(@PathVariable Integer id) {
        return mesaService.findById(id);
    }

    @PostMapping
    public void saveTable(@RequestBody @Valid MesaDTO mesaDTO) {
        mesaService.saveTable(mesaDTO);
    }

    @PatchMapping("/{id}")
    public void updateTable(@PathVariable Integer id, @RequestBody @Valid MesaDTO mesaDTO) {
        mesaService.updateTable(id, mesaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Integer id) {
        mesaService.deleteTable(id);
    }
}