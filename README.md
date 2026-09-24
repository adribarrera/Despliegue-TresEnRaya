# Tres en Raya (Java)

El clásico juego del **Tres en Raya** implementado en Java para jugar por consola entre 2 jugadores por turnos.

---

##¿Cómo funciona?

1. **Elige quién empieza:** Al arrancar la partida, se elige si comienza jugando `X` o `O`.
2. **Turnos y coordenadas:** En cada turno, introduces la **fila (1-3)** y la **columna (1-3)** donde quieres colocar tu ficha.
3. **Validación de jugadas:** El juego controla si metes números fuera de rango, letras o si intentas tirar en una casilla ya ocupada.
4. **Fin de partida:** El juego detecta automáticamente victorias (en horizontal, vertical o diagonales) o si la partida termina en **empate** al llenarse el tablero.

---

## Estructura del proyecto

El código está organizado en el paquete `com.daw`:

- `Main.java`: Gestiona el bucle principal, los menús de entrada por consola y el flujo de la partida.
- `Partida.java`: Controla el estado general del juego (turnos, ganador y condición de fin).
- `Tablero.java`: Representa la matriz, valida casillas, dibuja el tablero y comprueba las combinaciones ganadoras.
- `Ficha.java`: Enum para representar las fichas (`X`, `O`) y gestionar el cambio de turno.

---

## Cómo ejecutarlo

### Con Maven:
```bash
cd tres-en-raya
mvn compile
mvn exec:java -Dexec.mainClass="com.daw.Main"
```

### O compilando directamente:
```bash
cd tres-en-raya/src/main/java
javac com/daw/*.java
java com.daw.Main
```