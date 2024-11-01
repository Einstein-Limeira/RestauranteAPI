package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

}