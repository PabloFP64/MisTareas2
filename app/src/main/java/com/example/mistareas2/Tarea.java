package com.example.mistareas2;

public class Tarea {

    private String nombre;
    private String coste;
    private String fecha;
    private String prioridad;
    private String descripcion;

    public Tarea(String nombre, String coste, String fecha, String prioridad, String descripcion){
        this.nombre = nombre;
        this.coste = coste;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.descripcion = descripcion;

    }
    public Tarea(){
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
