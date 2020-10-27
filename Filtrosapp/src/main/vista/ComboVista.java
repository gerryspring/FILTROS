package main.vista;

import Componentes.StandardComboBox;
import Componentes.StandardLabel;
import main.controlador.ComboControlador;

import javax.swing.*;
import java.awt.*;

public class ComboVista extends JFrame {

    JPanel panel;
    StandardLabel statesLabel, municipalitiesLabel, citiesLabel;
    public String state, municipalitie, city;
    public StandardComboBox combostate, combomunicipalities, combocities;

    public ComboVista() {
        super("ESTADOS MUNICIPIOS Y CIUDADES");
        state = null;
        municipalitie = null;
        city = null;
        doInterface();
    }

    public ComboVista(String estado) {
        super("ESTADOS MUNICIPIOS Y CIUDADES");
        state = estado;
        municipalitie = null;
        city = null;
        doInterface();

    }

    public ComboVista(String estado, String municipio) {
        super("ESTADOS MUNICIPIOS Y CIUDADES");
        state = estado;
        municipalitie = municipio;
        city = null;
        doInterface();

    }

    public void setEstados(String[] estados) {
        combostate.setEnabled(true);
        combostate.removeAllItems();
        combostate.insertItemAt("SELECCIONE", 0);
        combostate.setSelectedIndex(0);

        for (int i = 0; i < estados.length; i++) {
            combostate.insertItemAt(estados[i].trim().toUpperCase(), (i + 1));
            if (state != null && state.compareToIgnoreCase(estados[i].trim()) == 0) {
                combostate.setSelectedIndex(i + 1);
            }
        }
    }

    public void setMunicipios(String[] municipios) {
        combomunicipalities.setEnabled(true);
        combomunicipalities.removeAllItems();
        combomunicipalities.insertItemAt("SELECCIONE", 0);
        combomunicipalities.setSelectedIndex(0);

        for (int i = 0; i < municipios.length; i++) {
            combomunicipalities.insertItemAt(municipios[i].trim().toUpperCase(), (i + 1));

            System.out.println(municipalitie + "\t" + municipios[i]);

            if (municipalitie != null && municipalitie.compareToIgnoreCase(municipios[i].trim()) == 0)
                combomunicipalities.setSelectedIndex(i + 1);
        }
    }

    public void setCiudades(String[] ciudades) {
        combocities.setEnabled(true);
        combocities.removeAllItems();
        combocities.insertItemAt("SELECCIONE", 0);
        combocities.setSelectedIndex(0);

        for (int i = 0; i < ciudades.length; i++) {
            combocities.insertItemAt(ciudades[i].trim().toUpperCase(), (i + 1));
        }
    }

    public void resetStates() {
        combomunicipalities.removeAllItems();
        combocities.removeAllItems();

        combomunicipalities.setEnabled(false);
        combocities.setEnabled(false);

        state = null;
        municipalitie = null;
        city = null;
    }

    public void resetMun() {
        combocities.removeAllItems();
        combocities.setEnabled(false);
    }

    public String getEstado() {
        return state;
    }

    public String getMunicipío() {
        return municipalitie;
    }

    public void setEstado(String estado) {
        state = estado;
    }

    public void setMunicipio(String municipio) {
        municipalitie = municipio;
    }


    private void doInterface() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        statesLabel = new StandardLabel("Estados", 16, JLabel.CENTER);
        municipalitiesLabel = new StandardLabel("Municipios", 16, JLabel.CENTER);
        citiesLabel = new StandardLabel("Ciudades", 16, JLabel.CENTER);

        combostate = new StandardComboBox();
        combomunicipalities = new StandardComboBox();
        combocities = new StandardComboBox();

        panel.add(statesLabel);
        panel.add(combostate);
        panel.add(municipalitiesLabel);
        panel.add(combomunicipalities);
        panel.add(citiesLabel);
        panel.add(combocities);

        add(panel);
    }

    public void setListeners(ComboControlador c) {
        combostate.addItemListener(c);
        combomunicipalities.addItemListener(c);
        combocities.addItemListener(c);
    }
}
