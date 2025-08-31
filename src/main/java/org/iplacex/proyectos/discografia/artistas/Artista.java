package org.iplacex.proyectos.discografia.artistas;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="artistas")
public class Artista {
    @Id
    public String _id ;
    public String nombre;
    public List<String> estilos;
    public int anioFundacion;
    public Boolean estaActivo;

    public Artista(){

    }

    public Artista(String _id, String nombre, List<String> estilos, int anioFundacion, Boolean estaActivo){
        this._id = _id;
        this.nombre = nombre;
        this.estilos = estilos;
        this.anioFundacion = anioFundacion;
        this.estaActivo = estaActivo;
    }
    public String get_id() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getEstilos() {
        return estilos;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstilos(List<String> estilos) {
        this.estilos = estilos;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

}
