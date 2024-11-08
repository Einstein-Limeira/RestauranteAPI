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
    public List<UsuarioDTO> findAllUsers() {
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findUserById(@PathVariable Integer id) {
        return usuarioService.getUserById(id);
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