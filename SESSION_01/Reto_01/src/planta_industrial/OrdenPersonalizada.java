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

public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }
    

    @Override
    public void mostrarResumen() {
        System.out.println("[Personalizada] Código: " + getCodigo() + ", Cantidad: " + getCantidad() + ", Cliente: " + cliente);
    }

    public void agregarCosto(int costo) {
        System.out.println("Se agregó un costo de ajuste de $" + costo + " a la orden del cliente: " + cliente);
    }
}