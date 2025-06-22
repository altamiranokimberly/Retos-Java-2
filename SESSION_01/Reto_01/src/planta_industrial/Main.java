/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planta_industrial;

import java.util.*;

public class Main {
    
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }
   
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).agregarCosto(costoAdicional);
            }
        }
    }

    
    public static void contarTipos(List<OrdenProduccion> todas) {
        int masa = 0, pers = 0, proto = 0;
        for (OrdenProduccion orden : todas) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) pers++;
            else if (orden instanceof OrdenPrototipo) proto++;
        }
        System.out.println("\nTotal de órdenes: Masa=" + masa + ", Personalizadas=" + pers + ", Prototipos=" + proto);
    }

    
    public static void main(String[] args) {
        // Crear órdenes
        OrdenMasa om1 = new OrdenMasa("C001", 1000);
        OrdenMasa om2 = new OrdenMasa("C002", 1500);

        OrdenPersonalizada op1 = new OrdenPersonalizada("K001", 50, "Cliente X");
        OrdenPersonalizada op2 = new OrdenPersonalizada("K002", 30, "Cliente Y");

        OrdenPrototipo pt1 = new OrdenPrototipo("T001", 5, "Alfa");
        OrdenPrototipo pt2 = new OrdenPrototipo("T002", 3, "Beta");

        List<OrdenProduccion> todas = new ArrayList<>();
        todas.add(om1); 
        todas.add(om2);
        todas.add(op1); 
        todas.add(op2);
        todas.add(pt1); 
        todas.add(pt2);

        System.out.println("\n Mostrando todas las órdenes:");
        mostrarOrdenes(todas); 

        System.out.println("\nProcesando órdenes personalizadas:");
        List<OrdenPersonalizada> soloPersonalizadas = Arrays.asList(op1, op2);
        procesarPersonalizadas(soloPersonalizadas, 150); // Cumple: modificar solo personalizadas

        contarTipos(todas); 
    }
}

