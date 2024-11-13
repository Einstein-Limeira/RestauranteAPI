package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
import br.com.einsteinlimeira.model.dto.PedidoProdutoDTO;
import br.com.einsteinlimeira.model.entity.PedidoProduto;
import br.com.einsteinlimeira.repository.PedidoProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoProdutoService {

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    public List<PedidoProdutoDTO> findAllProductsOrders() {
        return pedidoProdutoRepository.findAll().stream().map(PedidoProdutoDTO::new).toList();
    }

    public PedidoProdutoDTO findProductOrderById(Integer id) {
        return pedidoProdutoRepository.findById(id).map(PedidoProdutoDTO::new).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));
    }

    public PedidoProdutoDTO saveProductOrder(PedidoProdutoDTO pedidoProdutoDTO) {
        return new PedidoProdutoDTO(pedidoProdutoRepository.save(pedidoProdutoDTO.toEntity()));
    }

    public PedidoProdutoDTO updateProductOrder(Integer id, PedidoProdutoDTO pedidoProdutoDTO) {
        PedidoProduto pedidoProduto = pedidoProdutoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));

        PedidoProduto newPedidoProduto = pedidoProdutoDTO.toEntity();
        BeanUtils.copyProperties(newPedidoProduto, pedidoProduto, "id");

        return new PedidoProdutoDTO(pedidoProdutoRepository.save(pedidoProduto));
    }

    public PedidoProdutoDTO deleteProductOrder(Integer id) {
        PedidoProduto pedidoProduto = pedidoProdutoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));
        pedidoProdutoRepository.delete(pedidoProduto);
        return new PedidoProdutoDTO(pedidoProduto);
    }
}