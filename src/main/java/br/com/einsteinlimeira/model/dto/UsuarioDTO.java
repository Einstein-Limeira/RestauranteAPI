package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotNull
    @Size(max = 30)
    private String nome;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(max = 40)
    private String senha;

    @NotNull
    private SituacaoCadastroDTO situacaoCadastro;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.situacaoCadastro = usuario.getSituacaoCadastro().getDescricao() != null ? new SituacaoCadastroDTO(usuario.getSituacaoCadastro().getDescricao()) : null;
    }

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setSituacaoCadastro(this.situacaoCadastro != null ? this.situacaoCadastro.toEntity() : null);
        return usuario;
    }
}