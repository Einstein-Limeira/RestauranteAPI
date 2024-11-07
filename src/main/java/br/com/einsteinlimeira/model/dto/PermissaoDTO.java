package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Permissao;
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
public class PermissaoDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 30)
    private String descricao;

    public PermissaoDTO(Permissao permissao) {
        this.id = permissao.getId();
        this.descricao = permissao.getDescricao();
    }

    public Permissao toEntity() {
        Permissao permissao = new Permissao();
        permissao.setId(id);
        permissao.setDescricao(descricao);
        return permissao;
    }
}