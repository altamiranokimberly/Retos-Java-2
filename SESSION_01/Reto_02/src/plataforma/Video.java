/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plataforma;

public class Video extends MaterialCurso {
    private int duracion; // minutos

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("🎥 Video: " + titulo + " | Autor: " + autor + " | Duración: " + duracion + " min");
    }
}