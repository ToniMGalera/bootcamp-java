package Tasca06;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Asiento {
    private int fila;
    private char columna;
    private Espectador espectador;

    // Constructor
    public Asiento(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
        this.espectador = null;
    }

    // Métodos getter y setter
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    // Método para verificar si el asiento está ocupado
    public boolean estaOcupado() {
        return espectador != null;
    }
}
