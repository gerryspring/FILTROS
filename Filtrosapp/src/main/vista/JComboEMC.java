package main.vista;

import Componentes.StandardComboBox;
import Componentes.StandardLabel;
import main.controlador.ComboControlador;

import javax.swing.*;
import java.awt.*;

public class JComboEMC extends JPanel {

    StandardLabel states,municipalities,cities;
    public int state;
    public String inputstate,inputminicipalitie;

    public StandardComboBox combostate, combomunicipalities,combocities;

    public JComboEMC(){
        doInterface();
        state = 1;
    }

    public JComboEMC(String estado){
        doInterface();
        inputstate = estado;
        state = 2;
    }

    public JComboEMC(String estado, String municipio){
        doInterface();
        inputstate = estado;
        inputminicipalitie = municipio;
        state = 3;
    }


    private void doInterface(){
        setLayout(new GridLayout(0,2));

        states = new StandardLabel("Estados",16,JLabel.CENTER);
        municipalities = new StandardLabel("Municipios",16,JLabel.CENTER);
        cities = new StandardLabel("Ciudades",16,JLabel.CENTER);

        combostate = new StandardComboBox();
        combomunicipalities = new StandardComboBox();
        combocities = new StandardComboBox();

        add(states);
        add(combostate);
        add(municipalities);
        add(combomunicipalities);
        add(cities);
        add(combocities);


    }

    public void setListeners(ComboControlador c){
        combostate.addItemListener(c);
        combomunicipalities.addItemListener(c);
        combocities.addItemListener(c);
    }

}
