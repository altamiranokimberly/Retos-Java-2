package org.kimberly;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class UCIMonitoring {

    private static final Random random = new Random();

    public static void main(String[] args) {

        // Pacientes
        Flux<String> paciente1 = generarFlujoPaciente(1);
        Flux<String> paciente2 = generarFlujoPaciente(2);
        Flux<String> paciente3 = generarFlujoPaciente(3);

        Flux.merge(paciente1, paciente2, paciente3)
                .onBackpressureDrop()
                .delayElements(Duration.ofSeconds(1)) // retarda los elementos para dar tiempo al consumo
                .subscribe(alerta -> System.out.println("⚠️ " + alerta));

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Flux<String> generarFlujoPaciente(int idPaciente) {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> generarEventoCritico(idPaciente))
                .filter(evento -> !evento.isEmpty())
                .subscribeOn(Schedulers.parallel())
                .onBackpressureDrop();
    }

    private static String generarEventoCritico(int pacienteId) {
        int fc = random.nextInt(160 - 40) + 40;
        int pas = random.nextInt(180 - 80) + 80; // presión sistólica
        int pad = random.nextInt(100 - 40) + 40; // presión diastólica
        int spo2 = random.nextInt(100 - 70) + 70;

        StringBuilder alerta = new StringBuilder();

        if (fc < 50 || fc > 120)
            alerta.append("Paciente ").append(pacienteId).append(" - FC crítica: ").append(fc).append(" bpm");

        if (pas < 90 || pas > 140 || pad < 60 || pad > 90) {
            if (alerta.length() > 0) alerta.append(" | ");
            alerta.append("Paciente ").append(pacienteId)
                    .append(" - PA crítica: ").append(pas).append("/").append(pad).append(" mmHg");
        }

        if (spo2 < 90) {
            if (alerta.length() > 0) alerta.append(" | ");
            alerta.append("Paciente ").append(pacienteId).append(" - SpO2 baja: ").append(spo2).append("%");
        }

        return alerta.toString();
    }
}