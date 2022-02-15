/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej4bidi;

import numeros.Numeros;

/**
 *
 * @author dam
 */
public class Ej4Bidi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nempleados;
        nempleados=Numeros.pedirNumero("Introduzca nº empleados: ", 0);
        Empresa miEmpresa = new Empresa (nempleados);
        
        miEmpresa.pedirDatosEmpleado();
        miEmpresa.pedirHijosTrabajador();
        miEmpresa.informe();
    }
    
}
