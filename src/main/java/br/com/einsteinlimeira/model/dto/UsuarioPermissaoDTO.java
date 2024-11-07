package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.UsuarioPermissao;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPermissaoDTO {

    private Integer id;

    @NotNull
    private UsuarioDTO usuario;

    @NotNull
    private PermissaoDTO permissao;

    public UsuarioPermissaoDTO(UsuarioPermissao usuarioPermissao) {
        this.id = usuarioPermissao.getId();
        this.usuario = usuarioPermissao.getUsuario() != null ? new UsuarioDTO(usuarioPermissao.getUsuario()) : null;
        this.permissao = usuarioPermissao.getPermissao() != null ? new PermissaoDTO(usuarioPermissao.getPermissao()) : null;
    }

    public UsuarioPermissao toEntity() {
        UsuarioPermissao usuarioPermissao = new UsuarioPermissao();
        usuarioPermissao.setId(this.id);
        usuarioPermissao.setUsuario(this.usuario != null ? this.usuario.toEntity() : null);
        usuarioPermissao.setPermissao(this.permissao != null ? this.permissao.toEntity() : null);
        return usuarioPermissao;
    }
}