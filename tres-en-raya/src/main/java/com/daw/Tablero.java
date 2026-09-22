package com.daw;

public class Tablero {
    private Ficha[][] casillas;

    public Tablero(int dim) {
        this.casillas = new Ficha[dim][dim];
    }

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

    protected boolean ganaVertical(Ficha ficha) {
        for (int j = 0; j < casillas[0].length; j++) {
            boolean columnaCompleta = true;
            for (int i = 0; i < casillas.length; i++) {
                if (casillas[i][j] == null || casillas[i][j] != ficha) {
                    columnaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }
        return false;
    }
}
