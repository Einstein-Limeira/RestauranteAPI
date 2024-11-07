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

    private StatusMesaDTO statusMesa;

    public MesaDTO(Mesa mesa) {
        this.id = mesa.getId();
        this.descricao = mesa.getDescricao();
        this.statusMesa = mesa.getStatusMesa() != null ? new StatusMesaDTO(mesa.getStatusMesa()) : null;
    }

    public Mesa toEntity() {
        Mesa mesa = new Mesa();
        mesa.setId(this.id);
        mesa.setDescricao(descricao);
        mesa.setStatusMesa(this.statusMesa != null ? this.statusMesa.toEntity() : null);
        return mesa;
    }
}