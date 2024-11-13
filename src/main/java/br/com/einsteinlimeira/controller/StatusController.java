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
    public ResponseEntity<List<StatusDTO>> getAllStatus() {
        return ResponseEntity.ok(statusService.findAllStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStatusById(@PathVariable Integer id) {
        return ResponseEntity.ok(statusService.findStatusById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StatusDTO> saveStatus(@RequestBody @Valid StatusDTO statusDTO) {
        return ResponseEntity.ok(statusService.saveStatus(statusDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable Integer id, @RequestBody @Valid StatusDTO statusDTO) {
        return ResponseEntity.ok(statusService.updateStatus(id, statusDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<StatusDTO> deleteStatus(@PathVariable Integer id) {
        return ResponseEntity.ok(statusService.deleteStatus(id));
    }
}