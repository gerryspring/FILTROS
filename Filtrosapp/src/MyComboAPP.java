import Componentes.JComboBox.JComboBoxEMC;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyComboAPP extends JFrame {
    JComboBoxEMC compontente,componente2,componente3;

    public MyComboAPP() throws IOException {
    hazInterfaz();
    }

    private void hazInterfaz() throws IOException {
        setSize(600,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compontente = new JComboBoxEMC();
        componente2 = new JComboBoxEMC("Sinaloa");
        componente3 = new JComboBoxEMC("Baja california","Ensenada");
        add(compontente, BorderLayout.NORTH);
        add(componente2);
        add(componente3,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new MyComboAPP();
    }
}
