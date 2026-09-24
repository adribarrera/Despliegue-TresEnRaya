package com.daw;

public class Tablero {
    private Ficha[][] casillas;

    public Tablero(int dim) {
        this.casillas = new Ficha[dim][dim];
    }

    // Coloca la ficha si la casilla está libre y dentro de los límites
    public boolean jugar(Ficha ficha, int fila, int columna) {
        if (fila < 0 || fila >= casillas.length || columna < 0 || columna >= casillas.length) {
            return false;
        } else if (casillas[fila][columna] == null) {
            casillas[fila][columna] = ficha;
            return true;
        } else {
            return false;
        }
    }

    public boolean estaLleno() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == null) {
                    return false; // Si hay algun hueco vacio, el tablero no estará lleno
                }
            }
        }
        return true;
    }

    // Comprueba si hay una fila completa con la misma ficha
    protected boolean ganaHorizontal(Ficha ficha) {
        for (int i = 0; i < casillas.length; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == null || casillas[i][j] != ficha) {
                    filaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }
        return false;
    }

    // Comprueba si hay una columna completa con la misma ficha
    protected boolean ganaVertical(Ficha ficha) {
        for (int j = 0; j < casillas[0].length; j++) {
            boolean columnaCompleta = true;
            for (int i = 0; i < casillas.length; i++) {
                if (casillas[i][j] == null || casillas[i][j] != ficha) {
                    columnaCompleta = false;
                    break;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }
        return false;
    }

    // Comprueba la diagonal principal (de arriba-izq a abajo-der)
    protected boolean ganaDiagonalDirecta(Ficha ficha) {
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i][i] != ficha) {
                return false;
            }
        }
        return true;
    }

    // Comprueba la diagonal secundaria (de arriba-der a abajo-izq)
    protected boolean ganaDiagonalIndirecta(Ficha ficha) {
        int n = casillas.length;
        for (int i = 0; i < n; i++) {
            if (casillas[i][n - 1 - i] != ficha) {
                return false;
            }
        }
        return true;
    }

    // Mira si se cumple cualquiera de las 4 formas de ganar
    public boolean gana(Ficha ficha) {
        return ganaHorizontal(ficha) || ganaVertical(ficha) ||
                ganaDiagonalDirecta(ficha) || ganaDiagonalIndirecta(ficha);
    }

    // Si la casilla es null devuelve un espacio para que al pintar quede vacía
    private String valueOf(Ficha ficha) {
        if (ficha == null) {
            return " ";
        } else {
            return ficha.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                sb.append(" ").append(valueOf(casillas[i][j])).append(" ");
                if (j < casillas[i].length - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < casillas.length - 1) {
                sb.append("---+---+---\n");
            }
        }
        return sb.toString();
    }
}
