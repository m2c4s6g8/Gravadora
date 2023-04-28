package br.edu.ifms.gravadora.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.gravadora.model.Artistas;
import br.edu.ifms.gravadora.model.Gravadora;
import br.edu.ifms.gravadora.model.Grupo;
import br.edu.ifms.gravadora.model.Musicas;
import br.edu.ifms.gravadora.repository.ArtistasRepository;
import br.edu.ifms.gravadora.repository.GravadoraRepository;
import br.edu.ifms.gravadora.repository.GrupoRepository;
import br.edu.ifms.gravadora.repository.MusicasRepository;



	@Service
	public class DBService {

		@Autowired
		GravadoraRepository repositoryGravadora;
		@Autowired
		ArtistasRepository repositoryArtistas;
		@Autowired
		GrupoRepository repositoryGrupo;
		@Autowired
		MusicasRepository repositoryMusicas;
		
		public void instantiateTestDatabase() throws ParseException{
			// TODO Auto-generated method stub
			
			Gravadora g1 = new Gravadora(null,"BigHits","30292825");
			Gravadora g2 = new Gravadora(null,"Music","02458745");
			
			Grupo gr1 = new Grupo(null, "BTS", 7);
			Grupo gr2 = new Grupo(null, "BlacKPink", 4 );
			Grupo gr3 = new Grupo(null, "TXT", 7);
			Grupo gr4 = new Grupo(null, "One", 12 );
			
			Musicas m1 = new Musicas(null,"Pink Venom","BlackPink","BlackPink",2017);
			Musicas m2 = new Musicas(null,"Mic Drop","BTS","BTS",2018);
			Musicas m3 = new Musicas(null,"Blue","BlackPink","BlackPink",2019);
			Musicas m4 = new Musicas(null,"DNA","BTS","BTS",2020);
			
			Artistas ar1 = new Artistas(null,"Jin",30,"1992",g1,gr3);
			Artistas ar2 = new Artistas(null,"Lisa",25,"1997",g2,gr2);
			Artistas ar3 = new Artistas(null,"JK",26,"1997",g2,gr4);
			Artistas ar4 = new Artistas(null,"Jimin",28,"1999",g1,gr1);
			
			
			ar1.getMusicas().addAll(Arrays.asList(m1,m2));
			ar2.getMusicas().addAll(Arrays.asList(m1,m4));
			ar3.getMusicas().addAll(Arrays.asList(m3,m2));
			ar4.getMusicas().addAll(Arrays.asList(m3,m4));
			
			
			
			
			
			repositoryGravadora.saveAll(Arrays.asList(g1,g2));
			repositoryGrupo.saveAll(Arrays.asList(gr1,gr2,gr3,gr4));
			
		repositoryMusicas.saveAll(Arrays.asList(m1,m2,m3,m4));
			repositoryArtistas.saveAll(Arrays.asList(ar1,ar2,ar3,ar4));
			
			
			
			//System.out.println("CHEGOU");
			
			
			
		}
}
