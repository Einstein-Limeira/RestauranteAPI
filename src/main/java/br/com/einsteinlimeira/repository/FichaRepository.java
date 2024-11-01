package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha, Integer> {

}