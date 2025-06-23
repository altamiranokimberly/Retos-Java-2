/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEspacial;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "🚁 Navegación: trayectoria corregida con éxito.";
    }
}
