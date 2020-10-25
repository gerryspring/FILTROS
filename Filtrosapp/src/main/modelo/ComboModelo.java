package main.modelo;

import main.modelo.FILES.ArchivoCiudades;
import main.modelo.FILES.ArchivoEstados;
import main.modelo.FILES.ArchivoMunicipios;
import main.vista.JComboEMC;

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

    public void setNames(JComboEMC combo) throws IOException {


        switch (combo.state){
            case 1:
                    setStates(combo);
                    break;
            case 2:
                    int check = statesFile.binarysearch(combo.inputstate);
                    if(check == -1)
                    return;

                    setStates(combo);

                    idState = statesFile.getID(check);
                    combo.combostate.setSelectedIndex(idState);
                    setMunicipalities(combo,idState);
                    break;

            case 3:
                    int checkstate = statesFile.binarysearch(combo.inputstate);
                    int checkmunicipalitie = municipalitiesFile.binarysearch(combo.inputminicipalitie);

                    if(checkstate == -1 || checkmunicipalitie == -1) {
                        System.out.println(checkstate + "\t" + checkmunicipalitie);
                        return;
                    }
                    setStates(combo);


                    idState = statesFile.getID(checkstate);
                    idMunicipalitie = municipalitiesFile.getID(checkmunicipalitie);

                    combo.combostate.setSelectedIndex(idState);
                    combo.combomunicipalities.setSelectedIndex(idMunicipalitie);

                    setCities(combo,idState,idMunicipalitie);
                    break;

        }
    }

    private void setStates(JComboEMC combo) throws IOException {
        combo.combostate.insertItemAt("SELECCIONE",0);
        combo.combostate.setSelectedIndex(0);
        String [] estados = statesFile.getAllData();
        for(int i=0;i<estados.length;i++)
            combo.combostate.insertItemAt(estados[i].trim(),(i+1));
    }

    private void setMunicipalities(JComboEMC combo,int idState) throws  IOException{
        combo.combomunicipalities.insertItemAt("SELECCIONE",0);
        combo.combomunicipalities.setSelectedIndex(0);

        String [] municipios = municipalitiesFile.getData(idState);
        for(int i=0;i<municipios.length;i++)
            combo.combomunicipalities.insertItemAt(municipios[i].trim().toUpperCase(),(i+1));
    }

    private void setCities(JComboEMC combo,int idState,int idMunicipalitie) throws IOException {
        combo.combocities.insertItemAt("SELECCIONE",0);
        combo.combocities.setSelectedIndex(0);

        String [] cities = citiesFile.getData(idState,idMunicipalitie);
        for(int i=0;i<cities.length;i++)
            combo.combocities.insertItemAt(cities[i].trim().toUpperCase(),(i+1));

    }

}
