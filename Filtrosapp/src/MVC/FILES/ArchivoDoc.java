package MVC.FILES;

import Componentes.ControladorFicheros;

import java.io.IOException;

public class ArchivoDoc extends ControladorFicheros {

    public ArchivoDoc(String ruta) throws IOException {
        super(ruta);
    }

    public ArchivoDoc() throws IOException{
        this("DOCUMENTO.DOC");
    }



    @Override
    public int getTamañoRegistro() {
        return 12;
    }
}
