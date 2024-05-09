package grupoCalculadoraT19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class grupoCalculadora extends JFrame {

    private JTextField campoEntrada;
    private JTextField campoResultado;
    private JLabel labelResultado;

    private String operacionActual = "";

    public grupoCalculadora() {
        setLayout(new BorderLayout());

        // Creamos los campos de texto
        campoEntrada = new JTextField(10);
        campoResultado = new JTextField(10);
        campoResultado.setEditable(false); // Hacer el campo no editable
        campoEntrada.setEditable(false); // No editable, la entrada se realizará mediante botones numéricos

        // Creamos los labels
        labelResultado = new JLabel("Resultado:");

        // Creamos los botones numéricos
        JPanel panelNumerico = new JPanel(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton botonNumero = new JButton(String.valueOf(i));
            botonNumero.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    campoEntrada.setText(campoEntrada.getText() + source.getText());
                }
            });
            panelNumerico.add(botonNumero);
        }
        // Botón cero
        JButton botonCero = new JButton("0");
        botonCero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoEntrada.setText(campoEntrada.getText() + "0");
            }
        });
        panelNumerico.add(botonCero);
        // Botón para borrar
        JButton botonBorrar = new JButton("C");
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoEntrada.setText("");
                campoResultado.setText("");
                operacionActual = "";
            }
        });
        panelNumerico.add(botonBorrar);

        // Creamos los botones de operaciones
        JPanel panelOperaciones = new JPanel(new FlowLayout());
        JButton botonSuma = new JButton("+");
        botonSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("+");
            }
        });
        panelOperaciones.add(botonSuma);

        JButton botonResta = new JButton("-");
        botonResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("-");
            }
        });
        panelOperaciones.add(botonResta);

        JButton botonMultiplicacion = new JButton("*");
        botonMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("*");
            }
        });
        panelOperaciones.add(botonMultiplicacion);

        JButton botonDivision = new JButton("/");
        botonDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("/");
            }
        });
        panelOperaciones.add(botonDivision);

        JButton botonIgual = new JButton("=");
        botonIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
        panelOperaciones.add(botonIgual);

        // Agregamos los componentes a la ventana
        add(campoEntrada, BorderLayout.NORTH);
        add(panelNumerico, BorderLayout.CENTER);
        add(panelOperaciones, BorderLayout.SOUTH);
        add(labelResultado, BorderLayout.WEST);
        add(campoResultado, BorderLayout.EAST);

        // Tamaño y título de la ventana
        setSize(300, 300);
        setTitle("MiniCalculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void agregarOperacion(String op) {
        if (campoEntrada.getText().isEmpty() && !campoResultado.getText().isEmpty()) {
            operacionActual = campoResultado.getText() + op;
        } else {
            operacionActual += campoEntrada.getText() + op;
        }
        campoEntrada.setText("");
    }

    private void calcularResultado() {
        if (!operacionActual.isEmpty()) {
            String expresion = operacionActual + campoEntrada.getText();
            double resultado = evaluarExpresion(expresion);
            campoResultado.setText(String.valueOf(resultado));
            campoEntrada.setText("");
            operacionActual = "";
        }
    }

    private double evaluarExpresion(String expresion) {
        double resultado = 0;
        try {
            resultado = evaluarExpresionSimple(expresion);
        } catch (ArithmeticException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la expresión");
        }
        return resultado;
    }

    private double evaluarExpresionSimple(String expresion) {
        String[] partes = expresion.split("(?<=[-+*/])|(?=[-+*/])");
        double acumulador = Double.parseDouble(partes[0].trim());

        for (int i = 1; i < partes.length; i += 2) {
            String operador = partes[i].trim();
            double operando = Double.parseDouble(partes[i + 1].trim());

            switch (operador) {
                case "+":
                    acumulador += operando;
                    break;
                case "-":
                    acumulador -= operando;
                    break;
                case "*":
                    acumulador *= operando;
                    break;
                case "/":
                    if (operando != 0) {
                        acumulador /= operando;
                    } else {
                        throw new ArithmeticException("División por cero");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operador desconocido: " + operador);
            }
        }

        return acumulador;
    }

    public static void main(String[] args) {
        new grupoCalculadora();
    }
}
