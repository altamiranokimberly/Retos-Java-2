package pizzeria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Ana", "domicilio", "555-1234"),
            new Pedido("Luis", "local", "555-5678"),
            new Pedido("Carlos", "domicilio", null),
            new Pedido("Lucía", "domicilio", "555-9999")
        );

        pedidos.stream()
            .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio")) //filtrar solo domicilio
            .map(Pedido::getTelefono) // obtenemos Optional<String> , recuperamos  los que tienen teléfono
            .filter(Optional::isPresent) 
            .map(Optional::get) // obtenemos el teléfono
            .map(tel -> "📞 Confirmación enviada al número: " + tel) 
            .forEach(System.out::println);
    }
}

