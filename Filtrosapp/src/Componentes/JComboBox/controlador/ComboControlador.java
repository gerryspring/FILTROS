package Componentes.JComboBox.controlador;

import Componentes.JComboBox.modelo.ComboModelo;
import Componentes.JComboBox.JComboBoxEMC;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ComboControlador implements ItemListener {
    JComboBoxEMC vista;
    ComboModelo modelo;

    public ComboControlador(JComboBoxEMC vista, ComboModelo modelo) throws IOException {
        this.vista = vista;
        this.modelo = modelo;

        setData();

    }

    public void setData() throws IOException {
        String estado = vista.getEstado();
        String municipio = vista.getMunicipío();

        String[] estados = modelo.getStates();
        vista.setEstados(estados);

        if (estado == null)
            return;
        else {
            String[] municipios = modelo.getMun(estado);
            vista.setMunicipios(municipios);

            if (municipio == null)
                return;
            else {
                String[] ciudades = modelo.getCities(municipio, estado);
                vista.setCiudades(ciudades);

            }
        }


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() != ItemEvent.SELECTED)
            return;
        if (e.getSource() == vista.combostate) {
            String cadena = (String) vista.combostate.getSelectedItem();
            System.out.println(cadena);

            if (cadena.compareTo("SELECCIONE") == 0) {
                vista.resetStates();
                return;

            }
            vista.setEstado(cadena);
            try {
                String municipios[] = modelo.getMun(cadena);

                vista.setMunicipios(municipios);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        if (e.getSource() == vista.combomunicipalities) {
            String cadena = (String) vista.combomunicipalities.getSelectedItem();
            System.out.println(cadena);

            if (cadena.compareTo("SELECCIONE") == 0) {
                vista.resetMun();
                return;
            }

            vista.setMunicipio(cadena);
            try {
                String ciudades[] = modelo.getCities(cadena, vista.getEstado());
                vista.setCiudades(ciudades);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

