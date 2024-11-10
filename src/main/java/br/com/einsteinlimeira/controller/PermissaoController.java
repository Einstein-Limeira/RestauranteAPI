package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.dto.PermissaoDTO;
import br.com.einsteinlimeira.service.PermissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> getAllPermissions() {
        return ResponseEntity.ok(permissaoService.findAllPermissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoDTO> getPermissionById(@PathVariable Integer id) {
        return ResponseEntity.ok(permissaoService.findPermissionById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PermissaoDTO> savePermission(@RequestBody @Valid PermissaoDTO permissaoDTO) {
        return ResponseEntity.ok(permissaoService.savePermission(permissaoDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<PermissaoDTO> updatePermission(@PathVariable Integer id, @RequestBody @Valid PermissaoDTO permissaoDTO) {
        return ResponseEntity.ok(permissaoService.updatePermission(id, permissaoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PermissaoDTO> deletePermission(@PathVariable Integer id) {
        return ResponseEntity.ok(permissaoService.deletePermission(id));
    }
}