import controlador.ComboControlador;
import modelo.ComboModelo;
import vista.ComboVista;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        ComboVista vista = new ComboVista();
        ComboModelo modelo = new ComboModelo();
        ComboControlador controlador = new ComboControlador(vista.combo,modelo);

        vista.combo.setListeners(controlador);
        vista.setVisible(true);
    }
}
