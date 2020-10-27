package clemente.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvControlador implements ActionListener {
    ConvVista vista;
    ConvModelo modelo;

    public ConvControlador(ConvVista vista,ConvModelo modelo){
        this.vista = vista;
        this.modelo = modelo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == vista.grabar) {
        String name = vista.getName();
        String age = vista.getAge();
        String key = modelo.setKey(name,age);
        vista.setResult(key);
        return;
    }
    if(e.getSource() == vista.listar){
        System.out.println("Lista");
        return;
    }
    }
}
