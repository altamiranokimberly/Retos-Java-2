/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plataforma;

public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public void marcarRevisado() {
        revisado = true;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " | Autor: " + autor + " | Revisado: " + revisado);
    }
}