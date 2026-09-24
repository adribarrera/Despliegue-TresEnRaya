package com.daw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("== TRES EN RAYA ==");

        Ficha fichaInicial = pedirFichaInicial(scan);
        Partida partida = new Partida(3, fichaInicial);

        // Bucle del juego hasta que alguien gane o haya empate
        while (!partida.terminada()) {
            System.out.println(partida);

            int fila = pedirCoordenada(scan, "fila");

            int columna = pedirCoordenada(scan, "columna");

            System.out.println();
            // Restamos 1 porque el usuario mete 1-3 y los índices van de 0 a 2
            partida.jugar(fila - 1, columna - 1);
        }

        System.out.println("== PARTIDA FINALIZADA ==");
        System.out.println(partida);

        Ficha ganador = partida.ganador();

        if (ganador != null) {
            System.out.println("Ha ganado la ficha: " + ganador);
        } else {
            System.out.println("Empate. No quedan casillas libres.");
        }
        scan.close();
    }

    // Pide la ficha que empieza y valida que sea X o O
    private static Ficha pedirFichaInicial(Scanner scan) {
        while (true) {
            System.out.print("¿Quién empieza jugando? (X / O): ");
            String entrada = scan.next().trim().toUpperCase();

            if (entrada.equals("X")) {
                return Ficha.X;
            } else if (entrada.equals("O")) {
                return Ficha.O;
            } else {
                System.out.println("Opción no válida. Introduce 'X' o 'O'.");
            }
        }
    }

    // Pide fila o columna y controla que sea un número válido entre 1 y 3
    private static int pedirCoordenada(Scanner scan, String tipo) {
        int valor = -1;
        while (valor < 1 || valor > 3) {
            System.out.println("Introduce la " + tipo + " (1-3): ");
            try {
                valor = scan.nextInt();
                if (valor < 1 || valor > 3) {
                    System.out.println("Error: El valor debe estar entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
                scan.nextLine(); // Limpiamos la entrada incorrecta
            }
        }
        return valor;
    }
}