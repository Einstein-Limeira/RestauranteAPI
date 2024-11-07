package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.UsuarioPermissaoDTO;
import br.com.einsteinlimeira.service.UsuarioPermissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariopermissao")
public class UsuarioPermissaoController {

    @Autowired
    private UsuarioPermissaoService usuarioPermissaoService;

    @GetMapping
    public List<UsuarioPermissaoDTO> getAllUsersPermissions() {
        return usuarioPermissaoService.getAllUsersPermissions();
    }

    @GetMapping("/{id}")
    public UsuarioPermissaoDTO getUserPermissionById(@PathVariable Integer id) {
        return usuarioPermissaoService.getUserPermissionById(id);
    }

    @PostMapping
    public UsuarioPermissaoDTO saveUserPermission(@RequestBody @Valid UsuarioPermissaoDTO usuarioPermissaoDTO) {
        return usuarioPermissaoService.saveUserPermission(usuarioPermissaoDTO);
    }

    @PatchMapping("/{id}")
    public UsuarioPermissaoDTO updateUserPermission(@PathVariable Integer id, @RequestBody @Valid UsuarioPermissaoDTO usuarioPermissaoDTO) {
        return usuarioPermissaoService.updateUserPermission(id, usuarioPermissaoDTO);
    }

    @DeleteMapping("/{id}")
    public UsuarioPermissaoDTO deleteUserPermission(@PathVariable Integer id) {
        return usuarioPermissaoService.deleteUserPermission(id);
    }
}