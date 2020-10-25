package MVC.FILES;

import Componentes.ControladorFicheros;
import Componentes.Utilidades;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArchivoDoc extends ControladorFicheros {
    private static int count = 1;

    public ArchivoDoc(String ruta) throws IOException {
        super(ruta);
    }

    public ArchivoDoc() throws IOException{
        this("DOCUMENTO.DOC");

    }

    public void record(String nom,int age) throws IOException{
        archivo.seek(archivo.length());
        String name = Utilidades.padString(nom,50);

        archivo.writeInt(count);
        archivo.writeUTF(name);
        archivo.writeInt(age);

        System.out.println(archivo.length() + "|"+count);
        count++;

    }

    public String getData(String nom) throws IOException {
        int index = binarysearch(nom);

        if(index == -1)
            return null;

        archivo.seek(index*getTamañoRegistro());
        int id = archivo.readInt();
        String name = archivo.readUTF();
        int age = archivo.readInt();

        return ("ID: "+id+"\tNAME: "+name.trim()+"\tAGE: "+age);
    }

    public ArrayList<String> getAllData() throws IOException {
        ArrayList<String> aux = new ArrayList<>();

        for(int i=0;i<getTotalRegistros();i++){
            archivo.seek(i*getTamañoRegistro());
            int id = archivo.readInt();
            String name = archivo.readUTF();
            int age = archivo.readInt();

            String chain = "ID: "+id+"\tNAME: "+name.trim()+"\tAGE: "+age;
            aux.add(chain);
        }
        return aux;
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

    public static void main(String[] args) throws IOException {
        ArchivoDoc doc = new ArchivoDoc("Test");

        ArrayList<String> aux = doc.getAllData();

        for(String element:aux){
            System.out.println(element);
        }


    }


    @Override
    public int getTamañoRegistro() {
        return 60;
    }
}
