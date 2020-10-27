package clemente.MVC;

import java.io.IOException;

public class ConvApl{
    public static void main(String[] args) throws IOException {
        ConvVista vista = new ConvVista();
        ConvModelo modelo = new ConvModelo();
        ConvControlador controlador = new ConvControlador(vista,modelo);

        vista.setListeners(controlador);

        vista.Mostrar();
    }
}
