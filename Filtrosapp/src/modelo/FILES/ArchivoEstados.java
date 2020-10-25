package modelo.FILES;

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
        super("ESTADOS.DOC");
    }

    public void record(String estado) throws IOException {
        System.out.println("LA LINGITUD ES: "+archivo.length());
        archivo.seek(archivo.length());

        String aux = Utilidades.padString(estado,50);
        archivo.writeInt(ID);
        archivo.writeUTF(aux);

        ID++;
    }
    public int binarysearch(String name) throws IOException {
        int centro,primero,ultimo;
        String valorCentro;
        primero = getTotalRegistros()-1;

        System.out.println("Total de registros: " + getTotalRegistros());
        ultimo = 0;


        while(ultimo<=primero){

            centro = (primero+ultimo) / 2;
            archivo.seek(centro*getTamañoRegistro()+4);

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
        return 56;
    }

    public static void main(String[] args) throws IOException {
        ArchivoEstados file = new ArchivoEstados();

        /**
        file.record("Baja California");
        file.record("Colima");
        file.record("Sinaloa");
        file.record("Ciudad de Mexico");
**/
       String[] aux = file.getAllData();

        for(String element:aux)
            System.out.println(element);



    }
}
