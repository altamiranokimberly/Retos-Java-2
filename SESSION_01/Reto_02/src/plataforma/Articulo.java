/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plataforma;

public class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📄 Artículo: " + titulo + " | Autor: " + autor + " | Palabras: " + palabras);
    }
}