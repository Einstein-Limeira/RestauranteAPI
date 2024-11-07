package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.PermissaoDTO;
import br.com.einsteinlimeira.service.PermissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<PermissaoDTO> getAllPermissions() {
        return permissaoService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public PermissaoDTO getPermissionById(@PathVariable Integer id) {
        return permissaoService.getPermissionById(id);
    }

    @PostMapping
    public PermissaoDTO savePermission(@RequestBody @Valid PermissaoDTO permissaoDTO) {
        return permissaoService.savePermission(permissaoDTO);
    }

    @PatchMapping("/{id}")
    public PermissaoDTO updatePermission(@PathVariable Integer id, @RequestBody @Valid PermissaoDTO permissaoDTO) {
        return permissaoService.updatePermission(id, permissaoDTO);
    }

    @DeleteMapping("/{id}")
    public PermissaoDTO deletePermission(@PathVariable Integer id) {
        return permissaoService.deletePermission(id);
    }
}