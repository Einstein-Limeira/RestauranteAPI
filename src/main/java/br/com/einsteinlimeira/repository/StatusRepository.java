package br.com.einsteinlimeira.repository;

import br.com.einsteinlimeira.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}