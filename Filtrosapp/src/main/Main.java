package main;

import main.controlador.ComboControlador;
import main.modelo.ComboModelo;
import main.vista.ComboVista;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ComboVista vista = new ComboVista();
        ComboModelo modelo = new ComboModelo();
        ComboControlador controlador = new ComboControlador(vista,modelo);
        vista.setListeners(controlador);
        vista.setVisible(true);
    }
}
