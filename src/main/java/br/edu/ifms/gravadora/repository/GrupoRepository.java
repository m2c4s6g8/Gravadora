package br.edu.ifms.gravadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.gravadora.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Integer>{

}
