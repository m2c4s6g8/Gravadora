package br.edu.ifms.gravadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.gravadora.model.Musicas;

@Repository
public interface MusicasRepository extends JpaRepository<Musicas,Integer> {

}
