package org.iplacex.proyectos.discografia.discos;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.iplacex.proyectos.discografia.artistas.IArtistaRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DiscoController {

    private final IDiscoRepository discoRepository;
    private final IArtistaRepository artistaRepository;

    public DiscoController(IDiscoRepository discoRepository, IArtistaRepository artistaRepository) {
        this.discoRepository = discoRepository;
        this.artistaRepository = artistaRepository;
    }

    @PostMapping(value = "/disco", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handlePostDiscoRequest(@RequestBody Disco disco) {
        try {
            if (!artistaRepository.existsById(disco.getIdArtista())) {
                return new ResponseEntity<>("Artista no encontrado", HttpStatus.NOT_FOUND);
            }
            Disco nuevoDisco = discoRepository.save(disco);
            return new ResponseEntity<>(nuevoDisco, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/discos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> handleGetDiscosRequest() {
        List<Disco> discos = discoRepository.findAll();
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }

    @GetMapping(value = "/disco/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleGetDiscoRequest(@PathVariable String id) {
        Optional<Disco> disco = discoRepository.findById(id);
        if (disco.isPresent()) {
            return new ResponseEntity<>(disco.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Disco no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/artista/{id}/discos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleGetDiscosByArtistaRequest(@PathVariable String id) {
        List<Disco> discos = discoRepository.findDiscosByIdArtista(id);
        if (discos.isEmpty()) {
            return new ResponseEntity<>("No se encontraron discos para el artista con ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }
}