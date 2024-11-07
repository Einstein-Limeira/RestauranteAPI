package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.UsuarioPermissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPermissaoRepository extends JpaRepository<UsuarioPermissao, Integer> {

}