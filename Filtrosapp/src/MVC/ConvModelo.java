package MVC;

import MVC.FILES.ArchivoDoc;

import java.io.IOException;

public class ConvModelo {
    private static int count;
    ArchivoDoc file;

    public ConvModelo() throws IOException {
        file = new ArchivoDoc();
    }

    public String setKey(String name, String age){
        String aux = ("00"+count) + (name.toUpperCase() +"#"+age);
        count++;
        return aux;
    }
}
