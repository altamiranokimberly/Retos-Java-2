package org.kimberly;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class MeridianPrimeSimulation {

    private static final Random random = new Random();

    public static void main(String[] args) {

        Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101)) // 0-100
                .filter(congestion -> congestion > 70)
                .doOnNext(c -> System.out.println("🚗 Congestión crítica: " + c + "%"))
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel())
                .subscribe();

        Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101)) // 0-100 ug/m3
                .filter(p -> p > 50)
                .doOnNext(p -> System.out.println("🌫️ Contaminación crítica: " + p + " ug/m3"))
                .subscribeOn(Schedulers.parallel())
                .subscribe();

        Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] levels = {"Baja", "Media", "Alta"};
                    return levels[random.nextInt(3)];
                })
                .filter(level -> level.equals("Alta"))
                .doOnNext(level -> System.out.println("🚑 Accidente crítico: Prioridad " + level))
                .subscribeOn(Schedulers.parallel())
                .subscribe();

        Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11)) // 0-10 min
                .filter(delay -> delay > 5)
                .doOnNext(d -> System.out.println("🚝 Tren maglev retrasado: " + d + " minutos"))
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel())
                .subscribe();

        Flux.interval(Duration.ofMillis(400))
                .scan(0, (acc, i) -> {
                    String color = new String[]{"Verde", "Amarillo", "Rojo"}[random.nextInt(3)];
                    return color.equals("Rojo") ? acc + 1 : 0;
                })
                .filter(count -> count >= 3)
                .doOnNext(c -> System.out.println("🚦 Semáforo en rojo consecutivo: " + c + " veces"))
                .subscribeOn(Schedulers.parallel())
                .subscribe();

        // Mantenemos la app viva
        try {
            Thread.sleep(15000); // 15 segundos de simulación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
