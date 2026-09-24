package com.daw;

public enum Ficha {
    X, O;

    // Devuelve el turno de la otra ficha
    public Ficha siguiente() {
        if (this == X) {
            return O;
        } else {
            return X;
        }
    }
}