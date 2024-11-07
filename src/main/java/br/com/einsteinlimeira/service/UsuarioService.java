package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
import br.com.einsteinlimeira.model.dto.UsuarioDTO;
import br.com.einsteinlimeira.model.entity.SituacaoCadastro;
import br.com.einsteinlimeira.model.entity.Usuario;
import br.com.einsteinlimeira.repository.SituacaoCadastroRepository;
import br.com.einsteinlimeira.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SituacaoCadastroRepository situacaoCadastroRepository;


    public List<UsuarioDTO> getAllUsers() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO getUserById(Integer id) {
        return usuarioRepository.findById(id).map(UsuarioDTO::new).orElseThrow(() -> new ResourceNotFoundException("Usuario", id));
    }

    public void saveUser(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioDTO.toEntity());
    }

    public void updateUser(Integer id, UsuarioDTO usuarioDTO) {
        Usuario findUser = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", id));

        Usuario newUser = usuarioDTO.toEntity();
        BeanUtils.copyProperties(newUser, findUser, "id");

        usuarioRepository.save(findUser);
    }

    public void deleteUser(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", id));

        if (usuario.getSituacaoCadastro().getId() == 1) {
            SituacaoCadastro situacaoExcluido = situacaoCadastroRepository.getReferenceById(0);

            usuario.setSituacaoCadastro(situacaoExcluido);
            usuarioRepository.save(usuario);
        }
        else {
            throw new RuntimeException("ERRO! O Usuário não pode ser deletado, pois o mesmo já se encontra excluído!");
        }
    }
}