package ej4bidi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dam
 */
public class Categoria {
    private String denominacion;
    private float sueldoBase;

    public Categoria(String denominacion, float sueldoBase) {
        this.denominacion = denominacion;
        this.sueldoBase = sueldoBase;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }
    
}
