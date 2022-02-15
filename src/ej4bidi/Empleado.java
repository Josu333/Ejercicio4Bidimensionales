package ej4bidi;



import Fecha.Fecha;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dam
 */
public class Empleado {

    private String nombre;
    private Fecha fechaAlta;
    private int idCategoria;
    private Hijo[] hijos;

    public Empleado(String nombre, Fecha fechaAlta,
            int Categoria, int nHijos) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.idCategoria = Categoria;
        if (nHijos != 0) {
            hijos = new Hijo[nHijos];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public int getCategoria() {
        return idCategoria;
    }

    public Hijo[] getHijos() {
        return hijos;
    }

    public void setUnHijo(Hijo hijo, int pos) {
        hijos[pos] = hijo;
    }

    public void setUnHijo(Fecha fNacimiento, boolean ingresos, int pos) {
        Hijo hijo = new Hijo(fNacimiento, ingresos);
        hijos[pos] = hijo;
    }

    public int nHijosComputables() {
        int total = 0;
        if (hijos != null) {
            for (int nHijos = 0; nHijos < hijos.length; nHijos++) {
                if (hijos[nHijos].validarHijo()) {
                   total++;
                }
            }
        }
        return total;
    }
}
