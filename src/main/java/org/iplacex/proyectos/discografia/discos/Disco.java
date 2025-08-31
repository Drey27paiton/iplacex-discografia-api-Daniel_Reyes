package org.iplacex.proyectos.discografia.discos;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "discos")
public class Disco {
    @Id
    public String _id;
    public String idArtista;
    public String nombre;
    public List<String> canciones;
    public int anioLanzamiento;
public Disco(){

    }

    public Disco(String _id, String idArtista, String nombre, List<String> canciones, int anioLanzamiento, Boolean estaActivo){
        this._id = _id;
        this.nombre = nombre;
        this.idArtista = idArtista;
        this.canciones = canciones;
        this.anioLanzamiento = anioLanzamiento;
    }
    public String get_id() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getIdArtista() {
        return idArtista;
    }
    public List<String> getCanciones() {
        return canciones;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }



    public void set_id(String _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }


}
