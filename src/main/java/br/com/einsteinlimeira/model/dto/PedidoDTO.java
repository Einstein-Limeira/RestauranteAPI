package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Integer id;

    @NotNull
    private Date data;

    @NotNull
    private StatusDTO status;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.status = pedido.getStatus() != null ? new StatusDTO(pedido.getStatus()) : null;
    }

    public Pedido toEntity() {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setData(data);
        pedido.setStatus(this.status != null ? this.status.toEntity() : null);
        return pedido;
    }
}