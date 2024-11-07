package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.UsuarioDTO;
import br.com.einsteinlimeira.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UsuarioDTO saveUser(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.saveUser(usuarioDTO);
    }

    @PatchMapping("/{id}")
    public UsuarioDTO updateUser(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.updateUser(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public UsuarioDTO deleteUser(@PathVariable Integer id) {
        return usuarioService.deleteUser(id);
    }
}