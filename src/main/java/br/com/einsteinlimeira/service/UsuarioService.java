package br.com.einsteinlimeira.service;

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

    public List<UsuarioDTO> findAllUsers() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO findUserById(Integer id) {
        Usuario findUser = usuarioRepository.getReferenceById(id);
        return new UsuarioDTO(findUser);
    }

    public UsuarioDTO saveUser(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity();
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO updateUser(Integer id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.getReferenceById(id);

        Usuario newUsuario = usuarioDTO.toEntity();
        BeanUtils.copyProperties(newUsuario, usuario, "id");

        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO deleteUser(Integer id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);

        if (usuario.getSituacaoCadastro().getId() == 1) {
            SituacaoCadastro situacaoExcluido = situacaoCadastroRepository.getReferenceById(0);

            usuario.setSituacaoCadastro(situacaoExcluido);
            return new UsuarioDTO(usuarioRepository.save(usuario));
        }
        else {
            throw new RuntimeException("ERRO! O Usuário não pode ser deletado, pois o mesmo já se encontra excluído!");
        }
    }
}