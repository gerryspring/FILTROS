package test;

import javax.swing.*;
import java.awt.*;

public class LecturaEnteros extends JFrame {

    TxtEntero txtEdad,txtEstatura,txtPeso;

    public LecturaEnteros(){
        super("Usando componentes de lectura enteros.");
        HazInterfaz();
        HazEscuchas();
    }

    private void HazInterfaz(){
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2));

        txtEdad = new TxtEntero(5);
        txtEstatura = new TxtEntero(8);
        txtPeso = new TxtEntero(6);

        add(new JLabel("Edad",JLabel.RIGHT));
        add(txtEdad);

        add(new JLabel("Estatura",JLabel.RIGHT));
        add(txtEstatura);

        add(new JLabel("Peso",JLabel.RIGHT));
        add(txtPeso);

        setVisible(true);


    }

    private void HazEscuchas(){

    }

    public static void main(String[] args) {
        new LecturaEnteros();
    }
}
