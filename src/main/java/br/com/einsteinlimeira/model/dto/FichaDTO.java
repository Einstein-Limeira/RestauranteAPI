package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Ficha;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FichaDTO {

    private Integer id;

    @NotNull
    private MesaDTO mesa;

    @NotNull
    private StatusDTO status;

    public FichaDTO(Ficha ficha) {
        this.id = ficha.getId();
        this.mesa = ficha.getMesa() != null ? new MesaDTO(ficha.getMesa()) : null;
        this.status = ficha.getStatus() != null ? new StatusDTO(ficha.getStatus()) : null;
    }

    public Ficha toEntity() {
        Ficha ficha = new Ficha();
        ficha.setId(id);
        ficha.setMesa(this.mesa != null ? this.mesa.toEntity() : null);
        ficha.setStatus(this.status != null ? this.status.toEntity() : null);
        return ficha;
    }
}