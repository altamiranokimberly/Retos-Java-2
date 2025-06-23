/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

   
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calculando Ruta ...");
                int tiempo = ThreadLocalRandom.current().nextInt(2, 4); 
                TimeUnit.SECONDS.sleep(tiempo);
                if (Math.random() < 0.1) throw new RuntimeException("Fallo al calcular la ruta");
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción en calcularRuta", e);
            }
        });
    }

   
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Estimando tarifa ...");
                int tiempo = ThreadLocalRandom.current().nextInt(1, 3); 
                TimeUnit.SECONDS.sleep(tiempo);
                if (Math.random() < 0.1) throw new RuntimeException("Fallo al estimar la tarifa");
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción en estimarTarifa", e);
            }
        });
    }

   
    public void procesarSolicitud() {
        CompletableFuture<String> rutaFuture = calcularRuta()
            .exceptionally(e -> {
                System.out.println("❌ Error en cálculo de ruta: " + e.getMessage());
                return "Ruta no disponible";
            });

        CompletableFuture<Double> tarifaFuture = estimarTarifa()
            .exceptionally(e -> {
                System.out.println("❌ Error en estimación de tarifa: " + e.getMessage());
                return -1.0;
            });

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            if (tarifa == -1.0 || ruta.equals("Ruta no disponible")) {
                return "⚠ No se pudo procesar la solicitud completamente.";
            }
            return "🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
        }).thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

       
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
