package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Status;
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
public class StatusDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 30)
    private String descricao;

    public StatusDTO(Status status) {
        this.id = status.getId();
        this.descricao = status.getDescricao();
    }

    public Status toEntity() {
        Status status = new Status();
        status.setId(id);
        status.setDescricao(descricao);
        return status;
    }
}