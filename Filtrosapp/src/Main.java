import main.controlador.ComboControlador;
import main.modelo.ComboModelo;
import main.vista.VistaPrincipal;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        VistaPrincipal vista = new VistaPrincipal();
        ComboModelo modelo = new ComboModelo();
        ComboControlador controlador = new ComboControlador(vista.combo,modelo);

        vista.combo.setListeners(controlador);
        vista.setVisible(true);
    }
}
