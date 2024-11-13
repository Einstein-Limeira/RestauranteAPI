package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.StatusMesaDTO;
import br.com.einsteinlimeira.service.StatusMesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("statusmesa")
public class MesaStatusController {

    @Autowired
    private StatusMesaService statusMesaService;

    @GetMapping
    public ResponseEntity<List<StatusMesaDTO>> getAllTableStatus() {
        return ResponseEntity.ok(statusMesaService.findAllTableStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<StatusMesaDTO> getTableStatusById(@PathVariable Integer id) {
        return ResponseEntity.ok(statusMesaService.findTableStatusById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StatusMesaDTO> saveTableStatus(@RequestBody @Valid StatusMesaDTO statusMesaDTO) {
        return ResponseEntity.ok(statusMesaService.saveTableStatus(statusMesaDTO));
    }

    @PatchMapping("{id}")
    @Transactional
    public ResponseEntity<StatusMesaDTO> updateTableStatus(@PathVariable Integer id, @RequestBody @Valid StatusMesaDTO statusMesaDTO) {
        return ResponseEntity.ok(statusMesaService.updateTableStatus(id, statusMesaDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<StatusMesaDTO> deleteTableStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(statusMesaService.deleteTableStatus(id));
    }
}