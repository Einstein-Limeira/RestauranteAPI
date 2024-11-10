package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
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

    public List<PedidoDTO> findAll() {
        return pedidoRepository.findAll().stream().map(PedidoDTO::new).toList();
    }

    public PedidoDTO findById(Integer id) {
        return pedidoRepository.findById(id).map(PedidoDTO::new).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));
    }

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        return new PedidoDTO(pedidoRepository.save(pedidoDTO.toEntity()));
    }

    public PedidoDTO update(Integer id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));

        Pedido newPedido = pedidoDTO.toEntity();
        BeanUtils.copyProperties(newPedido, pedido, "id");

        return new PedidoDTO(pedidoRepository.save(pedido));
    }

    public PedidoDTO delete(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));

        pedidoRepository.delete(pedido);

        return new PedidoDTO(pedido);
    }
}