/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planta_industrial;

/**
 *
 * @author Jardin
 */
public class OrdenPrototipo extends OrdenProduccion {
    private String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    public String getFaseDesarrollo() {
        return faseDesarrollo;
    }

    
    @Override
    public void mostrarResumen() {
        System.out.println("[Prototipo] Código: " + getCodigo() + ", Cantidad: " + getCantidad() + ", Fase: " + faseDesarrollo);
    }
}