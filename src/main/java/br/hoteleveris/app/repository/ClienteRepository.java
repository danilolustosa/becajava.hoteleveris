package br.hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	

}
