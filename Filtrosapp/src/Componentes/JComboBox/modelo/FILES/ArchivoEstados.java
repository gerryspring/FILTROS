package Componentes.JComboBox.modelo.FILES;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;

import java.io.IOException;
import java.util.ArrayList;

public class ArchivoEstados extends ControladorFicheros {
    private static int ID = 1;

    public ArchivoEstados(String ruta) throws IOException {
        super(ruta);
    }


    public ArchivoEstados() throws IOException {
        super("D:/EMC/ESTADOS.DOC");
    }

    public void record(String estado) throws IOException {
        System.out.println("LA LINGITUD ES: " + archivo.length());
        archivo.seek(archivo.length());

        String aux = Utilidades.padString(estado, 50);
        archivo.writeInt(ID);
        archivo.writeUTF(aux);

        ID++;
    }

    public int binarysearch(String name) throws IOException {
        int centro, primero, ultimo;
        String valorCentro;
        primero = getTotalRegistros() - 1;
        ultimo = 0;


        while (ultimo <= primero) {

            centro = (primero + ultimo) / 2;
            archivo.seek(centro * getTamañoRegistro());

            int x = archivo.readInt();
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
        archivo.seek(index * getTamañoRegistro());
        return archivo.readInt();
    }

    public String[] getAllData() throws IOException {

        ArrayList<String> aux = new ArrayList<>();

        for (int i = 0; i < getTotalRegistros(); i++) {
            archivo.seek(i * getTamañoRegistro());
            int id = archivo.readInt();
            String name = archivo.readUTF();

            String chain = name.trim().toUpperCase();
            aux.add(chain);
        }

        String[] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }

    public void ordenar() throws IOException {
        String statei, statej;
        int idi, idj;

        archivo.seek(0);

        for (int i = 0; i < getTotalRegistros() - 1; i++) {
            for (int j = i + 1; j < getTotalRegistros(); j++) {

                archivo.seek(i * getTamañoRegistro());
                idi = archivo.readInt();
                statei = archivo.readUTF();

                archivo.seek(j * getTamañoRegistro());
                idj = archivo.readInt();
                statej = archivo.readUTF();


                if (statei.compareToIgnoreCase(statej) > 0) {
                    archivo.seek(i * getTamañoRegistro());

                    archivo.writeInt(idj);
                    archivo.writeUTF(statej);

                    archivo.seek(j * getTamañoRegistro());

                    archivo.writeInt(idi);
                    archivo.writeUTF(statei);
                }
            }
        }
    }


    @Override
    public int getTamañoRegistro() {
        return 56;
    }

    /**
     ArchivoEstados file = new ArchivoEstados();



     file.record("Baja California");
     file.record("Colima");
     file.record("Sinaloa");
     file.record("Ciudad  mexico");

     file.ordenar();
     **/
}
