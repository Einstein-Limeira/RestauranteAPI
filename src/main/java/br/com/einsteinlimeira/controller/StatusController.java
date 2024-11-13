package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.StatusDTO;
import br.com.einsteinlimeira.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAll() {
        return ResponseEntity.ok(statusService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(statusService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StatusDTO> save(@RequestBody @Valid StatusDTO statusDTO) {
        return ResponseEntity.ok(statusService.save(statusDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<StatusDTO> update(@PathVariable Integer id, @RequestBody @Valid StatusDTO statusDTO) {
        return ResponseEntity.ok(statusService.update(id, statusDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<StatusDTO> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(statusService.delete(id));
    }
}