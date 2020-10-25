package vista;

import MVC.ConvControlador;
import controlador.ComboControlador;

import javax.swing.*;

public class ComboVista extends JFrame {

    public JComboEMC combo;

    public ComboVista(){
        super("ESTADOS MUNICIPIOS Y CIUDADES.");
        doInterface();
    }

    private void doInterface(){
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        combo = new JComboEMC("BAJA CALIFORNIA");

        add(combo);

    }
}
