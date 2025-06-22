/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plataforma;

import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("⏱ Duración total de videos: " + total + " minutos");
    }


    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                ((Ejercicio) obj).marcarRevisado();
                System.out.println("✅ Ejercicio marcado como revisado: " + ((Ejercicio) obj).titulo);
            }
        }
    }

    public static List<MaterialCurso> filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        List<MaterialCurso> resultado = new ArrayList<>();
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                resultado.add(material);
            }
        }
        return resultado;
    }
}
