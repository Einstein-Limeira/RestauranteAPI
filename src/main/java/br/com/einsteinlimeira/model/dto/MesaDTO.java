package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Mesa;
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
public class MesaDTO {

    private Integer id;

    @NotNull
    @Size(max = 40)
    private String descricao;

    public MesaDTO(Mesa mesa) {
        this.id = mesa.getId();
        this.descricao = mesa.getDescricao();
    }

    public Mesa toEntity() {
        Mesa mesa = new Mesa();
        mesa.setId(id);
        mesa.setDescricao(descricao);
        return mesa;
    }
}