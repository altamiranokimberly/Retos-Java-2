/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🔄 Iniciando verificación para autorización de aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        
        CompletableFuture<Void> validaciones = CompletableFuture.allOf(pista, clima, trafico, personal);

        validaciones.thenApply(voided -> {
            try {
                boolean todasCondiciones = pista.get() && clima.get() && trafico.get() && personal.get();

                if (todasCondiciones) {
                    System.out.println("\n🛬 Aterrizaje AUTORIZADO ✅: todas las condiciones son óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje DENEGADO ❌: al menos una condición no fue óptima.");
                }

            } catch (Exception e) {
                System.out.println("⚠ Error al obtener resultados: " + e.getMessage());
            }
            return null;
        }).join(); 
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("Verificando pista...");
            boolean disponible = random.nextInt(100) < 80;
            System.out.println("✅ Pista disponible: " + disponible);
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("Verificando clima...");
            boolean favorable = random.nextInt(100) < 85;
            System.out.println("🌦 Clima favorable: " + favorable);
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("Verificando tráfico aéreo...");
            boolean despejado = random.nextInt(100) < 90;
            System.out.println("🛫 Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("Verificando personal en tierra...");
            boolean disponible = random.nextInt(100) < 95;
            System.out.println("👷‍ Personal en tierra disponible: " + disponible);
            return disponible;
        });
    }

    private static void simularLatencia(String mensaje) {
        try {
            System.out.println("⏳ " + mensaje);
            TimeUnit.SECONDS.sleep(2 + random.nextInt(2)); // 2-3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
