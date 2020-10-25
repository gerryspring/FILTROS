package main.vista;

import javax.swing.*;

public class VistaPrincipal extends JFrame {

    public JComboEMC combo;

    public VistaPrincipal(){
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
