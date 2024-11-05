package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.StatusMesa;
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
public class StatusMesaDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 30)
    private String descricao;

    public StatusMesaDTO(StatusMesa statusMesa) {
        this.id = statusMesa.getId();
        this.descricao = statusMesa.getDescricao();
    }

    public StatusMesa toEntity() {
        StatusMesa statusMesa = new StatusMesa();
        statusMesa.setId(id);
        statusMesa.setDescricao(descricao);
        return statusMesa;
    }
}