/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        lock.lock();
        try {
            System.out.println(profesional + " ha entrado a " + nombre);
            Thread.sleep(1000); 
            System.out.println(profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println(profesional + " fue interrumpido mientras usaba " + nombre);
        } finally {
            lock.unlock();
        }
    }
} 
