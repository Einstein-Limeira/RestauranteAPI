package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.StatusMesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusMesaRepository extends JpaRepository<StatusMesa, Integer> {

}