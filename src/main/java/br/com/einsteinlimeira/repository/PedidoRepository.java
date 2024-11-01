package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}