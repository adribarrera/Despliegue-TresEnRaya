package com.daw;

public class Partida {
    private Tablero tablero;
    private Ficha turno;

    public Partida(int dimension) {
        this.tablero = new Tablero(dimension);
        this.turno = Ficha.X;
    }

    public Partida(int dimension, Ficha turnoInicial) { // Sobrecarga para que se pueda elegir la ficha que empieza
        this.tablero = new Tablero(dimension);
        this.turno = turnoInicial;
    }

    public void jugar(int fila, int columna) {
        if (terminada()) {
            System.out.println("La partida ha finalizado.");
            return;
        }

        boolean jugadaValida = tablero.jugar(turno, fila, columna);
        if (jugadaValida) {
            turno = turno.siguiente();
        } else {
            System.out.println("Casilla no válida u ocupada. Vuelve a intentarlo");
        }
    }

    public Ficha ganador() {
        if (tablero.gana(Ficha.X)) {
            return Ficha.X;
        } else if (tablero.gana(Ficha.O)) {
            return Ficha.O;
        } else {
            return null;
        }
    }

    public boolean terminada() {
        if (ganador() != null) {
            return true;
        } else if (tablero.estaLleno()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turno actual: ").append(turno).append("\n\n");
        sb.append(tablero.toString());
        return sb.toString();
    }

}
