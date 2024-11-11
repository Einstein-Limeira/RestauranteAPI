package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {

}