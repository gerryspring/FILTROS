package main.vista;

import main.controlador.ComboControlador;
import main.modelo.ComboModelo;

import javax.swing.*;
import java.io.IOException;

public class VistaPrincipal extends JFrame {

    private JComboEMC vista;
    private ComboModelo modelo;
    private ComboControlador controlador;

    public VistaPrincipal() throws IOException {
        super("ESTADOS MUNICIPIOS Y CIUDADES.");
        doInterface();
    }

    private void doInterface() throws IOException {
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        vista = new JComboEMC("Baja california","Ensenada");
        modelo = new ComboModelo();
        controlador = new ComboControlador(vista,modelo);

        vista.setListeners(controlador);
        add(vista);

    }
}
