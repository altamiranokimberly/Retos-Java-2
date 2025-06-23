/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEspacial;

import java.util.concurrent.*;
import java.util.*;

public class SimulacionMisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> tareas = Arrays.asList(
            new SistemaNavegacion(),
            new SistemaSoporteVital(),
            new SistemaControlTermico(),
            new SistemaComunicaciones()
        );

        try {
            List<Future<String>> resultados = executor.invokeAll(tareas);
            for (Future<String> futuro : resultados) {
                System.out.println(futuro.get());
            }
            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("❌ Error en la simulación: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
