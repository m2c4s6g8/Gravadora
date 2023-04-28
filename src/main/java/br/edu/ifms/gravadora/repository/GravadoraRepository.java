package br.edu.ifms.gravadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.gravadora.model.Gravadora;

@Repository
public interface GravadoraRepository extends JpaRepository<Gravadora,Integer>{

}
