/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4bidi;

import Fecha.Fecha;
import numeros.Numeros;
import textos.Textos;

/**
 *
 * @author josu3
 */
public class Empresa {

    Empleado[] empleados;
    Categoria[] categorias;
    final float[] limites;
    float[][] irpf;

    public Empresa(int nempleados) {

        empleados = new Empleado[nempleados];

        categorias = new Categoria[]{
            new Categoria("Administrativo", 1000f),
            new Categoria("Programador", 1200f),
            new Categoria("Analista", 1500f),
            new Categoria("Analista Programador", 1800f),
            new Categoria("Jefe Junior", 2100f),
            new Categoria("Jefe Senior", 2200f)
        };

        limites = new float[]{1000f, 1200f, 1500f, 1800f, 2100f, Float.MAX_VALUE};
        irpf = new float[][]{
            {0.08f, 0.1f, 0.16f, 0.21f, 0.3f},
            {0.6f, 0.8f, 0.14f, 0.19f, 0.25f},
            {0.04f, 0.05f, 0.12f, 0.17f, 0.21f},
            {0.03f, 0.04f, 0.1f, 0.15f, 0.2f}
        };

    }

    public void pedirDatosEmpleado() {
        String nombre;
        Fecha fechaAlta;
        int categoria;
        int numHijos;

        for (int ne = 0; ne < empleados.length; ne++) {
            nombre = Textos.pedirString("Nombre del empleado: ");
            fechaAlta = Textos.pedirFecha("Introduce fecha de alta: ");
            mostrar();
            categoria = Numeros.pedirNumero("Intro categoria: ", 0, categorias.length - 1);
            numHijos = Numeros.pedirNumero("Intro numero de hijos: ", 0);
            empleados[ne] = new Empleado(nombre, fechaAlta, categoria, numHijos);

        }
    }

    private void mostrar() {
        for (int c = 0; c < categorias.length; c++) {
            System.out.println(c + "\t" + categorias[c].getDenominacion());
        }
    }

    public void pedirHijosTrabajador() {
        int total;
        Fecha fnac; //del hijo
        boolean ingresos;
        for (int ne = 0; ne < empleados.length; ne++) {

            if (empleados[ne].getHijos() != null) {
                System.out.println(empleados[ne].getNombre());
                total = empleados[ne].getHijos().length;
                for (int nh = 0; nh < total; nh++) {
                    fnac=Textos.pedirFecha("Fecha de nacimiento del hijo"+(nh+1)+" :");
                    ingresos=Textos.pedirBoolean("¿Tiene ingreso superiores a 8000 euros?: ");
                    empleados[ne].setUnHijo(new Hijo(fnac, ingresos), nh);
                    //empleados[ne].setUnHijo(fnac, ingresos, nh); 
                    //aqui creamos los hijos en el método; en el otro ya le has  
                    //creado y se lo pasas.

                }
            }
        }
    }
    
    public void informe (){
        cabecera();
        int fila;
        float irpfTotal;
        for(int pos=0;pos<empleados.length;pos++){
            fila=empleados[pos].nHijosComputables();
            
            System.out.println(empleados[pos].getNombre());
            System.out.println(empleados[pos].getFechaAlta());
            
            System.out.println(fila);
            if(fila>=irpf.length){
                fila=irpf.length-1;
            }
            irpfTotal=irpf[fila][calcularColumna(categorias[empleados[pos].getCategoria()].getSueldoBase())];
            System.out.println("\t"+categorias[empleados[pos].getCategoria()].getDenominacion());
            System.out.println(categorias[empleados[pos].getCategoria()].getSueldoBase());
            
            System.out.println("\t"+irpfTotal);
            float importeNeto=categorias[empleados[pos].getCategoria()].getSueldoBase()*(1-irpfTotal);
        }
                
        
    }
    public void cabecera(){
        System.out.println("\t\t INFORME ANUAL");
        System.out.print("\t Nombre");
        System.out.print("Fecha de alta");
        System.out.print("Nº hijos");
        System.out.print("Categoria");
        System.out.print("Sueldo Base");
        System.out.print("IRPF");
        System.out.print("Sueldo Neto");
    }
    
    private int calcularColumna(float sueldo){
        int pos=0;
        while (limites[pos]<sueldo){
            pos++;
        }
        return pos;
    }

}
