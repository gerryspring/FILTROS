package Componentes.JComboBox;

import Componentes.StandardLabel;
import Componentes.JComboBox.controlador.ComboControlador;
import Componentes.JComboBox.modelo.ComboModelo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class JComboBoxEMC extends JPanel {

    ComboModelo modelo;
    ComboControlador controlador;

    StandardLabel statesLabel, municipalitiesLabel, citiesLabel;
    public String state, municipalitie, city;
    public StandardComboBox combostate, combomunicipalities, combocities;

    public JComboBoxEMC() throws IOException {
        state = null;
        municipalitie = null;
        city = null;
        doInterface();
    }

    public JComboBoxEMC(String estado) throws IOException {
        state = estado;
        municipalitie = null;
        city = null;
        doInterface();

    }

    public JComboBoxEMC(String estado, String municipio) throws IOException {
        state = estado;
        municipalitie = municipio;
        city = null;
        doInterface();

    }
    private void doInterface() throws IOException {
        setSize(400, 200);
        setLayout(new GridLayout(0, 2));
        setBorder(new LineBorder(Color.RED));



        statesLabel = new StandardLabel("Estados", 16, JLabel.CENTER);
        municipalitiesLabel = new StandardLabel("Ciudades", 16, JLabel.CENTER);
        citiesLabel = new StandardLabel("Colonias", 16, JLabel.CENTER);

        combostate = new StandardComboBox();
        combomunicipalities = new StandardComboBox();
        combocities = new StandardComboBox();

        add(statesLabel);
        add(combostate);
        add(municipalitiesLabel);
        add(combomunicipalities);
        add(citiesLabel);
        add(combocities);

        modelo = new ComboModelo();
        controlador = new ComboControlador(this,modelo);
        setListeners(controlador);


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


    public void setListeners(ComboControlador c) {
        combostate.addItemListener(c);
        combomunicipalities.addItemListener(c);
        combocities.addItemListener(c);
    }
}
