package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.SituacaoCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoCadastroRepository extends JpaRepository<SituacaoCadastro, Integer> {

}