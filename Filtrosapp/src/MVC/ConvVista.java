package MVC;

import Componentes.NumberField;
import Componentes.TextField;

import javax.swing.*;
import java.awt.*;

public class ConvVista extends JFrame {
    JLabel name,age,result,output;
    TextField nameT;
    NumberField ageT;

    public ConvVista(){
        doInterface();
        doListeners();

        setVisible(true);
    }

    private void doInterface(){
        setTitle("Formulario");
        setSize(600,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2));

        name = new JLabel("Name",JLabel.CENTER);
        age = new JLabel("Age",JLabel.CENTER);
        result = new JLabel("Result: ",JLabel.CENTER);
        output = new JLabel("", JLabel.CENTER);

        nameT = new TextField(50);
        ageT = new NumberField(15);

        add(name);
        add(nameT);
        add(age);
        add(ageT);
        add(result);
        add(output);


    }

    private void doListeners(){

    }

    public static void main(String[] args) {
        new ConvVista();
    }
}
