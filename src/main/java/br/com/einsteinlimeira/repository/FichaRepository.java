package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Integer> {

}