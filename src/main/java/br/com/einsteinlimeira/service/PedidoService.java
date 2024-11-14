package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.model.dto.PedidoDTO;
import br.com.einsteinlimeira.model.entity.Pedido;
import br.com.einsteinlimeira.repository.PedidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDTO> findAllOrders() {
        return pedidoRepository.findAll().stream().map(PedidoDTO::new).toList();
    }

    public PedidoDTO findOrderById(Integer id) {
        Pedido findOrder =  pedidoRepository.getReferenceById(id);
        return new PedidoDTO(findOrder);
    }

    public PedidoDTO saveOrder(PedidoDTO pedidoDTO) {
        return new PedidoDTO(pedidoRepository.save(pedidoDTO.toEntity()));
    }

    public PedidoDTO updateOrder(Integer id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.getReferenceById(id);

        Pedido newPedido = pedidoDTO.toEntity();
        BeanUtils.copyProperties(newPedido, pedido, "id");

        return new PedidoDTO(pedidoRepository.save(pedido));
    }

    public PedidoDTO deleteOrder(Integer id) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedidoRepository.delete(pedido);
        return new PedidoDTO(pedido);
    }
}