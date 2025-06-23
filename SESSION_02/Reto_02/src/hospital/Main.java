/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Simulación acceso a Sala de Cirugía iniciada...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        Runnable profesional1 = () -> salaCirugia.usar("Dra. Sánchez");
        Runnable profesional2 = () -> salaCirugia.usar("Enfermero López");
        Runnable profesional3 = () -> salaCirugia.usar("Dr. Hernández");
        Runnable profesional4 = () -> salaCirugia.usar("Dra. Rivera");
        Runnable profesional5 = () -> salaCirugia.usar("Interna Gómez");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(profesional1);
        executor.execute(profesional2);
        executor.execute(profesional3);
        executor.execute(profesional4);
        executor.execute(profesional5);

        executor.shutdown();
    }
}
