package main.controlador;

import main.modelo.ComboModelo;
import main.vista.JComboEMC;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ComboControlador implements ItemListener {

    JComboEMC vista;
    ComboModelo modelo;

    public ComboControlador(JComboEMC vista , ComboModelo modelo) throws IOException {
        this.vista = vista;
        this.modelo = modelo;

        modelo.setNames(this.vista);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()!=ItemEvent.SELECTED)
            return;

        if(e.getSource() == vista.combostate){
            String cadena = (String) vista.combostate.getSelectedItem();

            if(cadena.compareTo("SELECCIONE")==0)
                return;

        }
    }
}
