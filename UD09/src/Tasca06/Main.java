package Tasca06;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine(new Pelicula("Pesadillas antes de Navidad", 75, 12, "Tim Burton"), 10.0, 8, 8);

        // info peli
        cine.mostrarInformacionPelicula();

        // Mostrar estado inicial de los asientos
        cine.mostrarEstadoAsientos();

        // espectadores
        ArrayList<Espectador> espectadores = new ArrayList<>();
        espectadores.add(new Espectador("Juan", 25, 15.0));
        espectadores.add(new Espectador("Ana", 30, 8.0));
        espectadores.add(new Espectador("Pedro", 16, 10.0));
        espectadores.add(new Espectador("María", 13, 5.0));
        espectadores.add(new Espectador("Luis", 7, 12.0));
        espectadores.add(new Espectador("Pep Guardiola", 25, 15.0));
        espectadores.add(new Espectador("Eustaquio Gonzalez", 30, 8.0));
        espectadores.add(new Espectador("Guillermo Diaz", 16, 10.0));
        espectadores.add(new Espectador("Alex Muzska", 35, 14.0));
        espectadores.add(new Espectador("Felipe", 7, 13.0));
        espectadores.add(new Espectador("Miquel", 25, 15.0));
        espectadores.add(new Espectador("Joseppe", 30, 8.0));
        espectadores.add(new Espectador("Alan", 16, 10.0));
        espectadores.add(new Espectador("Marie", 13, 122.0));
        espectadores.add(new Espectador("Pelé", 7, 16.0));
        espectadores.add(new Espectador("Messi", 25, 18.0));
        espectadores.add(new Espectador("Agapito Di Sousa", 30, 11.0));
        espectadores.add(new Espectador("Samuel de Luque", 16, 10.0));
        espectadores.add(new Espectador("Juan Alberto", 35, 14.0));
        espectadores.add(new Espectador("Bruno Diaz", 7, 13.0));


        // Sentar
        for (Espectador espectador : espectadores) {
            boolean pudoSentarse = cine.sentarEspectador(espectador);
            if (pudoSentarse) {
                JOptionPane.showMessageDialog(null, espectador.getNombre() + " se ha sentado en un asiento.");
            } else {
                JOptionPane.showMessageDialog(null, espectador.getNombre() + " no cumple los requisitos o no hay asientos disponibles.");
            }
        }

        // Mostrar estado actualizado de los asientos
        cine.mostrarEstadoAsientos();
    }

}