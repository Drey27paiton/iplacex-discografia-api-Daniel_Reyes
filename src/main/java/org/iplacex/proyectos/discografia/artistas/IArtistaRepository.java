package org.iplacex.proyectos.discografia.artistas;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface IArtistaRepository extends MongoRepository<Artista, String>{
    
}
