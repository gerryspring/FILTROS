package Componentes.JComboBox.modelo;

import Componentes.JComboBox.modelo.FILES.ArchivoCiudades;
import Componentes.JComboBox.modelo.FILES.ArchivoEstados;
import Componentes.JComboBox.modelo.FILES.ArchivoMunicipios;

import java.io.IOException;

public class ComboModelo {
    ArchivoEstados estados = new ArchivoEstados();
    ArchivoMunicipios municipios = new ArchivoMunicipios();
    ArchivoCiudades ciudades = new ArchivoCiudades();

    public ComboModelo() throws IOException {

    }

    public String[] getStates() throws IOException {
        String[] aux = estados.getAllData();

        return aux;
    }

    public String[] getMun(String estado) throws IOException {

        int idstate = estados.binarysearch(estado);
        idstate = estados.getID(idstate);
        String[] aux = municipios.getData(idstate);
        return aux;
    }

    public String[] getCities(String mun, String estado) throws IOException {

        int indexmun = municipios.binarysearch(mun);
        int indexestado = estados.binarysearch(estado);
        System.out.println(indexestado + "\t" + indexmun);
        indexmun = municipios.getID(indexmun);
        indexestado = estados.getID(indexestado);


        System.out.println(indexestado + "\t" + indexmun);

        String[] aux = ciudades.getData(indexestado, indexmun);

        return aux;
    }
}
