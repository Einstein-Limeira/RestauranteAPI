package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {

}