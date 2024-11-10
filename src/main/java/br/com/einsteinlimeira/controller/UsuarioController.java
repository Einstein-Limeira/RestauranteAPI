package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.UsuarioDTO;
import br.com.einsteinlimeira.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        return ResponseEntity.ok(usuarioService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findUserById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> saveUser(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.saveUser(usuarioDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> updateUser(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.updateUser(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.deleteUser(id));
    }
}