package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {

}