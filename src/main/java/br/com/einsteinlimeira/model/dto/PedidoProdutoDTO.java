package br.com.einsteinlimeira.model.dto;

import br.com.einsteinlimeira.model.entity.PedidoProduto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProdutoDTO {

    private Integer id;

    @NotNull
    private ProdutoDTO produto;

    @NotNull
    private PedidoDTO pedido;

    @NotNull
    private Integer quantidade;

    public PedidoProdutoDTO(PedidoProduto pedidoProduto) {
        this.id = pedidoProduto.getId();
        this.produto = pedidoProduto.getProduto() != null ? new ProdutoDTO(pedidoProduto.getProduto()) : null;
        this.pedido = pedidoProduto.getPedido() != null ? new PedidoDTO(pedidoProduto.getPedido()) : null;
        this.quantidade = pedidoProduto.getQuantidade();
    }

    public PedidoProduto toEntity() {
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setId(this.id);
        pedidoProduto.setProduto(this.produto != null ? this.produto.toEntity() : null);
        pedidoProduto.setPedido(this.pedido != null ? this.pedido.toEntity() : null);
        pedidoProduto.setQuantidade(this.quantidade);
        return pedidoProduto;
    }
}