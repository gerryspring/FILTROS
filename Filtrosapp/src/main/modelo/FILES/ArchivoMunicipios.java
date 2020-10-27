package main.modelo.FILES;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;

import java.io.IOException;
import java.util.ArrayList;

public class ArchivoMunicipios extends ControladorFicheros {
    public ArchivoMunicipios(String ruta) throws IOException {
        super(ruta);
    }


    public ArchivoMunicipios() throws IOException {
        super("MUNICIPIOS.DOC");
    }

    public void record(int IDESTADO, int IDMUNICIPIO, String municipio) throws IOException {
        System.out.println("LA LINGITUD ES: " + archivo.length());
        archivo.seek(archivo.length());

        String aux = Utilidades.padString(municipio, 50);

        archivo.writeInt(IDESTADO);
        archivo.writeInt(IDMUNICIPIO);
        archivo.writeUTF(aux);

    }

    public void ordenar() throws IOException {
        String muni, munj;
        int idi, idj, idei, idej;

        archivo.seek(0);

        for (int i = 0; i < getTotalRegistros() - 1; i++) {
            for (int j = i + 1; j < getTotalRegistros(); j++) {

                archivo.seek(i * getTamañoRegistro());
                idi = archivo.readInt();
                idei = archivo.readInt();
                muni = archivo.readUTF();

                archivo.seek(j * getTamañoRegistro());
                idj = archivo.readInt();
                idej = archivo.readInt();
                munj = archivo.readUTF();

                if (muni.compareToIgnoreCase(munj) > 0) {
                    archivo.seek(i * getTamañoRegistro());

                    archivo.writeInt(idj);
                    archivo.writeInt(idej);
                    archivo.writeUTF(munj);

                    archivo.seek(j * getTamañoRegistro());

                    archivo.writeInt(idi);
                    archivo.writeInt(idei);
                    archivo.writeUTF(muni);
                }
            }
        }
    }


    public String[] getData(int stateID) throws IOException {
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < getTotalRegistros(); i++) {
            archivo.seek(i * getTamañoRegistro());
            int id = archivo.readInt();
            archivo.skipBytes(4);
            if (id == stateID)
                aux.add(archivo.readUTF());

        }

        String[] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }

    public int binarysearch(String name) throws IOException {
        int centro, primero, ultimo;
        String valorCentro;
        primero = getTotalRegistros();

        System.out.println("Total de registros: " + getTotalRegistros());
        ultimo = 0;
        while (ultimo <= primero) {

            centro = (primero + ultimo) / 2;
            archivo.seek(centro * getTamañoRegistro() + 8);

            valorCentro = archivo.readUTF().trim();

            int pos = name.compareToIgnoreCase(valorCentro);

            if (pos == 0)
                return centro;
            else if (pos > 0)
                ultimo = centro + 1;
            else
                primero = centro - 1;
        }
        return -1;
    }


    public int getID(int index) throws IOException {
        archivo.seek(index * getTamañoRegistro() + 4);
        return archivo.readInt();
    }

    public String[] getAllData() throws IOException {
        ArrayList<String> aux = new ArrayList<>();

        for (int i = 0; i < getTotalRegistros(); i++) {
            archivo.seek(i * getTamañoRegistro());

            int id = archivo.readInt();
            int idst = archivo.readInt();
            String name = archivo.readUTF();

            String chain = name.trim().toUpperCase();
            aux.add(chain);
        }

        String[] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }

    @Override
    public int getTamañoRegistro() {
        return 60;
    }

/**
 ArchivoMunicipios file = new ArchivoMunicipios();

 file.record(1, 1, "Ensenada");
 file.record(1, 2, "Mexicali");
 file.record(1, 3, "Tecate");
 file.record(1, 4, "Tijuana");
 file.record(1, 5, "Playas de Rosarito");
 file.record(1, 6, "San Quintin");

 file.record(2, 1, "Armeria");
 file.record(2, 2, "Colima");
 file.record(2, 3, "Comala");
 file.record(2, 4, "Coquimatlan");

 file.record(3, 1, "Ahome");
 file.record(3, 2, "Angostura");
 file.record(3, 3, "Badiraguato");
 file.record(3, 4, "Culiacan");

 file.record(4, 1, "Alvaro Obregon");
 file.record(4, 2, "Iztapalapa");
 file.record(4, 3, "Benito Juarez");
 file.record(4, 4, "Coyocan");

 file.ordenar();
 **/
}
