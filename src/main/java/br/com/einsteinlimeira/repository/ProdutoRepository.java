package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}