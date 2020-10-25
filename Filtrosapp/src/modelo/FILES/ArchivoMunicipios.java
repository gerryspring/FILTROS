package modelo.FILES;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArchivoMunicipios extends ControladorFicheros {
    private static int ID = 1;

    public ArchivoMunicipios(String ruta) throws IOException {
        super(ruta);
    }


    public ArchivoMunicipios() throws IOException {
        super("MUNICIPIOS.DOC");
    }

    public void record(int IDESTADO,String municipio) throws IOException {
        System.out.println("LA LINGITUD ES: "+archivo.length());
        archivo.seek(archivo.length());

        String aux = Utilidades.padString(municipio,50);

        archivo.writeInt(ID);
        archivo.writeInt(IDESTADO);
        archivo.writeUTF(aux);

        ID++;
    }

    public String[] getData(int stateID) throws IOException {
        ArrayList<String> aux = new ArrayList<>();
        for(int i=0;i<getTotalRegistros();i++) {
            archivo.seek(i*getTamañoRegistro()+4);
            int id = archivo.readInt();

            System.out.println(id + "\t" + stateID);
            if(id==stateID)
                aux.add(archivo.readUTF());

        }

        String [] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }

    public int binarysearch(int stateID) throws IOException {
        int centro,primero,ultimo;
        int valorCentro;
        primero = getTotalRegistros()-1;

        System.out.println("Total de registros: " + getTotalRegistros());
        ultimo = 0;


        while(ultimo<=primero){

            centro = (primero+ultimo) / 2;
            archivo.seek(centro*getTamañoRegistro()+4);

            valorCentro = archivo.readInt();


            int pos = stateID;

            if(pos==valorCentro)
                return centro;
            else if(pos>valorCentro)
                ultimo = centro+1;
            else
                primero  = centro-1;
        }
        return -1;
    }

    public int binarysearch(String name) throws IOException {
        int centro,primero,ultimo;
        String valorCentro;
        primero = getTotalRegistros()-1;

        System.out.println("Total de registros: " + getTotalRegistros() + name);
        ultimo = 0;


        while(ultimo<=primero){

            centro = (primero+ultimo) / 2;
            archivo.seek(centro*getTamañoRegistro()+8);

            valorCentro = archivo.readUTF().trim();
            System.out.println(valorCentro);


            int pos = name.compareToIgnoreCase(valorCentro);

            if(pos==0)
                return centro;
            else if(pos>0)
                ultimo = centro+1;
            else
                primero  = centro-1;
        }
        return -1;
    }
    public int getID(int index) throws IOException {
        archivo.seek(index*getTamañoRegistro());
        return  archivo.readInt();
    }

    public String[] getAllData() throws IOException {
        ArrayList<String> aux = new ArrayList<>();

        for(int i=0;i<getTotalRegistros();i++){
            archivo.seek(i*getTamañoRegistro());
            int id = archivo.readInt();
            String name = archivo.readUTF();

            String chain = name.trim().toUpperCase();
            aux.add(chain);
        }

        String [] list = new String[aux.size()];
        list = aux.toArray(list);

        return list;
    }
    @Override
    public int getTamañoRegistro() {
        return 60;
    }

    public static void main(String[] args) throws IOException {
        ArchivoMunicipios file = new ArchivoMunicipios();
/**
         file.record(1,"Ensenada");
         file.record(1,"Mexicali");
         file.record(1,"Tecate");
         file.record(1,"Tijuana");
         file.record(1,"Playas de Rosarito");
         file.record(1,"San Quintin");

         file.record(2,"Armeria");
         file.record(2,"Colima");
         file.record(2,"Comala");
         file.record(2,"Coquimatlan");

         file.record(3,"Ahome");
         file.record(3,"Angostura");
         file.record(3,"Badiraguato");
         file.record(3,"Culiacan");

         file.record(4,"Alvaro Obregon");
         file.record(4,"Iztapalapa");
         file.record(4,"Benito Juarez");
         file.record(4,"Coyocan");

**/


    }
}