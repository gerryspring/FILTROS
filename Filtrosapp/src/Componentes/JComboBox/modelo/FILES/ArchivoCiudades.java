package Componentes.JComboBox.modelo.FILES;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;

import java.io.IOException;
import java.util.ArrayList;

public class ArchivoCiudades extends ControladorFicheros {
    private static int ID = 1;

    public ArchivoCiudades(String ruta) throws IOException {
        super(ruta);
    }


    public ArchivoCiudades() throws IOException {
        super("D:/EMC/CIUDADES.DOC");
    }

    public void ordenar() throws IOException {
        String cityi, cityj;
        int idi, idj, idei, idej, idmi, idmj;

        archivo.seek(0);

        for (int i = 0; i < getTotalRegistros() - 1; i++) {
            for (int j = i + 1; j < getTotalRegistros(); j++) {

                archivo.seek(i * getTamañoRegistro());
                idi = archivo.readInt();
                idei = archivo.readInt();
                idmi = archivo.readInt();
                cityi = archivo.readUTF();

                archivo.seek(j * getTamañoRegistro());
                idj = archivo.readInt();
                idej = archivo.readInt();
                idmj = archivo.readInt();
                cityj = archivo.readUTF();

                if (cityi.compareToIgnoreCase(cityj) > 0) {
                    archivo.seek(i * getTamañoRegistro());
                    System.out.println("Escribiendo");
                    archivo.writeInt(idj);
                    archivo.writeInt(idej);
                    archivo.writeInt(idmj);
                    archivo.writeUTF(cityj);

                    archivo.seek(j * getTamañoRegistro());

                    archivo.writeInt(idi);
                    archivo.writeInt(idei);
                    archivo.writeInt(idmi);
                    archivo.writeUTF(cityi);
                }
            }
        }
    }


    public void record(int IDESTADO, int IDMUNICIPIO, String ciudad) throws IOException {
        System.out.println("LA LINGITUD ES: " + archivo.length());
        archivo.seek(archivo.length());

        String aux = Utilidades.padString(ciudad, 50);

        archivo.writeInt(ID);
        archivo.writeInt(IDESTADO);
        archivo.writeInt(IDMUNICIPIO);
        archivo.writeUTF(aux);

        ID++;
    }

    public String[] getData(int stateID, int municipalitieID) throws IOException {
        ArrayList<String> aux = new ArrayList<>();

        for (int i = 0; i < getTotalRegistros(); i++) {
            archivo.seek(i * getTamañoRegistro() + 4);
            int ids = archivo.readInt();
            int idm = archivo.readInt();

            if (ids == stateID && idm == municipalitieID)
                aux.add(archivo.readUTF());

        }

        String[] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }

    public int binarysearch(int stateID) throws IOException {
        int centro, primero, ultimo;
        int valorCentro;
        primero = getTotalRegistros() - 1;

        System.out.println("Total de registros: " + getTotalRegistros());
        ultimo = 0;


        while (ultimo <= primero) {

            centro = (primero + ultimo) / 2;
            archivo.seek(centro * getTamañoRegistro() + 4);

            valorCentro = archivo.readInt();


            int pos = stateID;

            if (pos == valorCentro)
                return centro;
            else if (pos > valorCentro)
                ultimo = centro + 1;
            else
                primero = centro - 1;
        }
        return -1;
    }

    public int binarysearch(String name) throws IOException {
        int centro, primero, ultimo;
        String valorCentro;
        primero = getTotalRegistros() - 1;

        System.out.println("Total de registros: " + getTotalRegistros());
        ultimo = 0;


        while (ultimo <= primero) {

            centro = (primero + ultimo) / 2;
            archivo.seek(centro * getTamañoRegistro() + 4);

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
            archivo.seek(i * getTamañoRegistro() + 12);
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
        return 64;
    }



//        file.ordenar();

        /**
         file.record(1,1,"La Mision");
         file.record(1,1,"El Porvenir");
         file.record(1,1,"Ojos Negros");
         file.record(1,1,"Maneadero");
         file.record(1,1,"San Antonio de las Minas");
         file.record(1,1,"El Sauzal");
         file.record(1,1,"Santo Tomas");
         file.record(1,1,"San Vicente");
         file.record(1,1,"Valle de la Trinidad");
         file.record(1,1,"Isla de Cedros");
         file.record(1,1,"San Quintin");
         file.record(1,1,"Puertecitos");


         file.record(1,2,"Santa Isabel");
         file.record(1,2,"Guadalupe Victoria");
         file.record(1,2,"San Felipe");
         file.record(1,2,"Puebla");
         file.record(1,2,"Progreso");
         file.record(1,2,"Ciudad Morelos");
         file.record(1,2,"Venustiano Carranza");
         file.record(1,2,"Ciudad Coahuila");
         file.record(1,2,"Vicente Guerrero");
         file.record(1,2,"Delta");
         file.record(1,2,"Ejido Hemorsillo");
         file.record(1,2,"Benito Juarez");
         file.record(1,2,"Nuevo Leon");
         file.record(1,2,"Poblado Paredones");
         file.record(1,2,"Michoacan de Ocampo");
         file.record(1,2,"Bataquez");

         file.record(1,3,"Lomas de Santa Anita");
         file.record(1,3,"Ejido Nueva Colonia Hindu");
         file.record(1,3,"Colonia Luis Echeverria");
         file.record(1,3,"La Rumorosa");
         file.record(1,3,"El Testerazo");
         file.record(1,3,"Mi Ranchito");
         file.record(1,3,"Colonia Aviacion");

         file.record(1,4,"Centro");
         file.record(1,4,"Otay Centenario");
         file.record(1,4,"Playas Tijuana");
         file.record(1,4,"La Mesa");
         file.record(1,4,"San Antonio de los Buenos");
         file.record(1,4,"La Presa");

         file.record(1,5,"Rosarito");

         file.record(1,6,"Ejido Lazaro Cardenas");
         file.record(1,6,"Colonia Vicente Guerrero");
         file.record(1,6,"Camalu");
         file.record(1,6,"Emiliano Zapata");
         file.record(1,6,"San Quintin");
         file.record(1,6,"Lomas de San Ramon");

         file.record(2,1,"Armeria");

         file.record(2,2,"Tapames");
         file.record(2,2,"Lo de Villa");
         file.record(2,2,"Piscila");
         file.record(2,2,"El Chanal");
         file.record(2,2,"Estapilla");
         file.record(2,2,"Las Ortices");
         file.record(2,2,"El Ocotillo");

         file.record(2,3,"Comala");
         file.record(2,3,"Suchitlan");
         file.record(2,3,"El Remate");
         file.record(2,3,"La Caja");

         file.record(2,4,"Coquimatlan");
         file.record(2,4,"Pueblo Juarez");
         file.record(2,4,"La Esperanza");
         file.record(2,4,"Jala");

         file.record(3,1,"Los Mochis");
         file.record(3,1,"Ahome");
         file.record(3,1,"Higuera de Zaragoza");
         file.record(3,1,"Topolobampo");

         file.record(3,2,"La Reforma");
         file.record(3,2,"Angostura");
         file.record(3,2,"Colonia Independencia");
         file.record(3,2,"Colonia Agricola Mexico");

         file.record(3,3,"Badiraguato");
         file.record(3,3,"Surutato");
         file.record(3,3,"San Jose del LLano");
         file.record(3,3,"Temeapa");

         file.record(3,4,"Culiacan Rosales");
         file.record(3,4,"El Dorado");
         file.record(3,4,"Costa Rica");
         file.record(3,4,"El Diez");
         file.record(3,4,"Culiacancito");

         file.record(4,1,"San Angel");
         file.record(4,1,"Aguilas");
         file.record(4,1,"Plateros");
         file.record(4,1,"Centenario");

         file.record(4,2,"Aculco");
         file.record(4,2,"Madgalena Atlazolpa");
         file.record(4,2,"San Juanico Nextipac");
         file.record(4,2,"Santa Maria Tomotlan");

         file.record(4,3,"Narvarte");
         file.record(4,3,"Portales");
         file.record(4,3,"Valle");
         file.record(4,3,"Napoles");

         file.record(4,4,"Villa Coyocan");
         file.record(4,4,"Del Carmen");
         file.record(4,4,"La Concepcion");
         file.record(4,4,"Santa Catarina");

         file.ordenar();
**/
    }
