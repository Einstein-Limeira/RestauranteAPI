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
    public ResponseEntity<List<FichaDTO>> getAllTickets() {
        return ResponseEntity.ok().body(fichaService.findAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaDTO> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(fichaService.findTicketById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FichaDTO> saveTicket(@RequestBody @Valid FichaDTO fichaDTO) {
        return ResponseEntity.ok().body(fichaService.saveTicket(fichaDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<FichaDTO> updateTicket(@PathVariable Integer id, @RequestBody @Valid FichaDTO fichaDTO) {
        return ResponseEntity.ok().body(fichaService.updateTicket(id, fichaDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<FichaDTO> deleteTicket(@PathVariable Integer id) {
        return ResponseEntity.ok().body(fichaService.deleteTicket(id));
    }
}