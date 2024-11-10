package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
import br.com.einsteinlimeira.model.dto.PermissaoDTO;
import br.com.einsteinlimeira.model.entity.Permissao;
import br.com.einsteinlimeira.repository.PermissaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;


    public List<PermissaoDTO> findAllPermissions() {
        return permissaoRepository.findAll().stream().map(PermissaoDTO::new).toList();
    }

    public PermissaoDTO findPermissionById(Integer id) {
        return permissaoRepository.findById(id).map(PermissaoDTO::new).orElseThrow(() -> new ResourceNotFoundException("Permissão", id));
    }

    public PermissaoDTO savePermission(PermissaoDTO permissaoDTO) {
        return new PermissaoDTO(permissaoRepository.save(permissaoDTO.toEntity()));
    }

    public PermissaoDTO updatePermission(Integer id, PermissaoDTO permissaoDTO) {
        Permissao permissao = permissaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Permissão", id));

        Permissao newPermission = permissaoDTO.toEntity();
        BeanUtils.copyProperties(newPermission, permissao, "id");

        return new PermissaoDTO(permissaoRepository.save(permissaoDTO.toEntity()));
    }

    public PermissaoDTO deletePermission(Integer id) {
        Permissao permissao = permissaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Permissão", id));
        permissaoRepository.delete(permissao);
        return new PermissaoDTO(permissao);
    }
}