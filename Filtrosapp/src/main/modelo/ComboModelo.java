package main.modelo;

import main.modelo.FILES.ArchivoCiudades;
import main.modelo.FILES.ArchivoEstados;
import main.modelo.FILES.ArchivoMunicipios;
import main.vista.JComboEMC;

import javax.swing.*;
import java.io.IOException;

public class ComboModelo {
    ArchivoEstados statesFile;
    ArchivoMunicipios municipalitiesFile;
    ArchivoCiudades citiesFile;

    private int idState,idMunicipalitie,idCity;

    public ComboModelo() throws IOException{
        statesFile = new ArchivoEstados();
        municipalitiesFile = new ArchivoMunicipios();
        citiesFile = new ArchivoCiudades();
    }

    String state = null;
    String municipalitie = null;

    public void setData(int state){

    }
    public void setNames(JComboEMC combo) throws IOException {

        switch (combo.valor){
            case 1:
                    setData(combo);
                    break;
            case 2:
                int busqueda = statesFile.binarysearch(combo.inputstate);

                if(busqueda == -1)
                    return;

                state = combo.inputstate;
                idState = statesFile.getID(busqueda);

                setData(combo);

                    break;

            case 3:

                int busquedaEstado = statesFile.binarysearch(combo.inputstate);
                int busquedaMunicipio = municipalitiesFile.binarysearch(combo.inputminicipalitie);

                if(busquedaEstado == -1 || busquedaMunicipio == -1)
                    return;

                state = combo.inputstate;
                idState = statesFile.getID(busquedaEstado);

                municipalitie = combo.inputminicipalitie;
                idMunicipalitie = municipalitiesFile.getID(busquedaMunicipio);

                setData(combo);
                    break;

        }
    }

    private void setData(JComboEMC combo) throws IOException {

        combo.combostate.insertItemAt("SELECCIONE",0);
        combo.combostate.setSelectedIndex(0);

        String[] estados = statesFile.getAllData();

            for (int i = 0; i < estados.length; i++) {
                combo.combostate.insertItemAt(estados[i].trim(), (i + 1));

                if(estados[i].equalsIgnoreCase(state)) {
                    combo.combostate.setSelectedIndex(i + 1);
                    setMunicipalities(combo);
                }
                }


    }

    private void setMunicipalities(JComboEMC combo) throws  IOException{

        combo.combomunicipalities.removeAllItems();

        combo.combomunicipalities.insertItemAt("SELECCIONE",0);
        combo.combomunicipalities.setSelectedIndex(0);

        String [] municipios = municipalitiesFile.getData(idState);

        for(int i=0;i<municipios.length;i++) {
            combo.combomunicipalities.insertItemAt(municipios[i].trim().toUpperCase(), (i + 1));

            if(municipalitie!=null){
             if(municipios[i].trim().equalsIgnoreCase(municipalitie.trim())) {
                 combo.combomunicipalities.setSelectedIndex(i + 1);
                 setCities(combo);
             }
            }

        }

        }

        public void setState(String estado, JComboEMC combo) throws IOException {
            int busqueda = statesFile.binarysearch(estado);
            idState = statesFile.getID(busqueda);
            setMunicipalities(combo);
        }

        public void setMunicipalitie(String estado, JComboEMC combo) throws IOException{
            int busqueda = municipalitiesFile.binarysearch(estado);
            idMunicipalitie = municipalitiesFile.getID(busqueda);
            setCities(combo);
        }

    private void setCities(JComboEMC combo) throws IOException  {
        combo.combocities.removeAllItems();

        combo.combocities.insertItemAt("SELECCIONE",0);
        combo.combocities.setSelectedIndex(0);

        String [] cities = citiesFile.getData(idState,idMunicipalitie);
        for(int i=0;i<cities.length;i++)
            combo.combocities.insertItemAt(cities[i].trim().toUpperCase(),(i+1));

    }

}
