package com.portal.exploradordefarmacias.modelo;

import java.io.Serializable;
import java.util.List;

public class Farmacia  implements Serializable {

    private String nombre;
    private String direccion;
    private String horario;
    private int foto;
    private List<String> caracteristicas;
    private String caracteristicasCadena;

    public Farmacia(String nombre, String direccion, String horario, int foto, List<String> caracteristicas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.foto = foto;
        this.caracteristicas = caracteristicas;
        this.caracteristicasCadena = caracteristicasCadena;
    }

    public String getCaracteristicasCadena() {
        return caracteristicasCadena;
    }

    public void setCaracteristicasCadena(String caracteristicasCadena) {
        this.caracteristicasCadena = caracteristicasCadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}