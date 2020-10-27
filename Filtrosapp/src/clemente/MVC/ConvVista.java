package clemente.MVC;

import Componentes.NumberField;
import Componentes.PanelGrid;
import Componentes.StandardLabel;
import Componentes.TextField;

import javax.swing.*;
import java.awt.*;

public class ConvVista extends JFrame {
    StandardLabel name,age,result,output;
    TextField nameT;
    NumberField ageT;
    PanelGrid center,south;
    JButton grabar,listar;
    GridLayout grid;

    public ConvVista(){
        super("Formu");
        doInterface();
    }

    private void doInterface() {
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        center = new PanelGrid(0, 2);
        south = new PanelGrid(0, 2);

        listar = new JButton("Listar");
        grabar = new JButton("Grabar");

        name = new StandardLabel("Name",16,JLabel.CENTER);
        age = new StandardLabel("Age",16,JLabel.CENTER);
        result = new StandardLabel("Result: ",16,JLabel.CENTER);
        output = new StandardLabel("",16, JLabel.CENTER);

        nameT = new TextField(50);
        ageT = new NumberField(15);

        center.add(name);
        center.add(nameT);
        center.add(age);
        center.add(ageT);
        center.add(result);
        center.add(output);


        south.add(grabar);
        south.add(listar);

        add(center,BorderLayout.CENTER);
        add(south,BorderLayout.SOUTH);

    }

    public void setListeners(ConvControlador c){
        listar.addActionListener(c);
        grabar.addActionListener(c);

    }

    public String getName(){

        return nameT.getText();
    }

    public String getAge(){
        return ageT.getText();
    }

    public void setResult(String key){
        output.setText(key);
    }

    public void Mostrar(){
        setVisible(true);
    }

}
