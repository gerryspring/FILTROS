package test;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;
import main.modelo.FILES.ArchivoEstados;
import main.modelo.FILES.ArchivoMunicipios;

import java.io.IOException;

public class BinTest extends ControladorFicheros {
    public static void main(String[] args) throws IOException {
        BinTest test = new BinTest("Testing.DOC");
        ArchivoEstados estados = new ArchivoEstados();
        ArchivoMunicipios municipios = new ArchivoMunicipios();
//
        String [] aux = estados.getAllData();
        String [] auxb = municipios.getAllData();

        int x = estados.binarysearch("Baja california");

        int y = municipios.binarysearch("Ensenada");
        System.out.println(x);

//        estados.ordenar();

       // municipios.ordenar();
        for(String elemento:auxb)
            System.out.println(elemento);


    }
    public BinTest(String rute) throws IOException {
        super(rute);
    }

    public void record(String nom) throws IOException {

        String name = Utilidades.padString(nom,10);

        archivo.writeUTF(name);

    }

    @Override
    public int getTamañoRegistro() {
        return 12;
    }
}
