package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.SituacaoCadastro;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SituacaoCadastroDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 30)
    private String descricao;

    public SituacaoCadastroDTO(SituacaoCadastro situacaoCadastro) {
        this.id = situacaoCadastro.getId();
        this.descricao = situacaoCadastro.getDescricao();
    }

    public SituacaoCadastro toEntity() {
        SituacaoCadastro situacaoCadastro = new SituacaoCadastro();
        situacaoCadastro.setId(this.id);
        situacaoCadastro.setDescricao(this.descricao);
        return situacaoCadastro;
    }

    public SituacaoCadastroDTO(String descricao) {
        this.descricao = descricao;
    }
}