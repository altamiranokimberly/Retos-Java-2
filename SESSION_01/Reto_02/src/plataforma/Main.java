/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plataforma;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        List<MaterialCurso> materiales = Arrays.asList(
        new Video("Intro a Java", "Juan Pérez", 10),
        new Video("POO en Java", "Ana Gómez", 15),
        new Articulo("Teoría de Clases", "Carlos Ruiz", 1200),
        new Articulo("Herencia y Polimorfismo", "Juan Pérez", 1500),
        new Ejercicio("Práctica 1", "Ana Gómez"),
        new Ejercicio("Práctica 2", "Carlos Ruiz"),
        new Ejercicio("Práctica 3", "Juan Pérez"));
        
        
 
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }
        
        System.out.println("📚 Todos los materiales:");
        PlataformaEducativa.mostrarMateriales(materiales);
    
        System.out.println("\n🎥 Duración total de videos:");
        PlataformaEducativa.contarDuracionVideos(videos);

        
        System.out.println("\n📝 Marcando ejercicios como revisados:");
        PlataformaEducativa.marcarEjerciciosRevisados(ejercicios);

        System.out.println("\n🔍 Filtrando por autor 'Juan Pérez':");
        List<MaterialCurso> filtrados = PlataformaEducativa.filtrarPorAutor(materiales, m -> m.getAutor().equals("Juan Pérez"));
        PlataformaEducativa.mostrarMateriales(filtrados);
        
    }
}
