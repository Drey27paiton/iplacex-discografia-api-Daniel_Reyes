package org.iplacex.proyectos.discografia.artistas;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArtistaController {

    private final IArtistaRepository artistaRepository;

    public ArtistaController(IArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @CrossOrigin(methods = RequestMethod.POST)
    @PostMapping(value = "/artista", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleInsertArtistaRequest(@RequestBody Artista artista) {
        try {
            Artista nuevoArtista = artistaRepository.save(artista);
            return new ResponseEntity<>(nuevoArtista, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(methods = RequestMethod.GET)
    @GetMapping(value = "/artistas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artista>> handleGetAristasRequest() {
        List<Artista> artistas = artistaRepository.findAll();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @CrossOrigin(methods = RequestMethod.GET)
    @GetMapping(value = "/artista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleGetArtistaRequest(@PathVariable String id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()) {
            return new ResponseEntity<>(artista.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Artista no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(methods = RequestMethod.PUT)
    @PutMapping(value = "/artista/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> handleUpdateArtistaRequest(@PathVariable String id, @RequestBody Artista artista) {
        if (!artistaRepository.existsById(id)) {
            return new ResponseEntity<>("Artista no encontrado", HttpStatus.NOT_FOUND);
        }
        artista.set_id(id); // Asegurar que el ID del objeto es el del path
        Artista artistaActualizado = artistaRepository.save(artista);
        return new ResponseEntity<>(artistaActualizado, HttpStatus.OK);
    }
    @CrossOrigin(methods = RequestMethod.DELETE)
    @DeleteMapping(value = "/artista/{id}")
    public ResponseEntity<Object> handleDeleteArtistaRequest(@PathVariable String id) {
        if (!artistaRepository.existsById(id)) {
            return new ResponseEntity<>("Artista no encontrado", HttpStatus.NOT_FOUND);
        }
        artistaRepository.deleteById(id);
        return new ResponseEntity<>("Artista eliminado exitosamente", HttpStatus.NO_CONTENT);
    }
}
