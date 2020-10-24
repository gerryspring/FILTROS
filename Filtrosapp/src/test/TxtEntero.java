package test;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TxtEntero extends JTextField implements KeyListener, FocusListener {

    private int tamaño; // representa el numero de digitos.
    Font font;



    public TxtEntero(int tamaño){
        this.tamaño = tamaño;
        HazEscuchadores();

        font = new Font("Tahoma",Font.BOLD,20);
    }


    private void HazEscuchadores() {
        addKeyListener(this);
        addFocusListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

        char car = e.getKeyChar();

        if (getText().length() == tamaño) {
            e.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }

//        if (e.getKeyChar() < 48 || e.getKeyChar() > '9'){
//        if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() > '-'){
          if ("0123456789-".indexOf(car) == -1){
            e.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }

          if(car == '-' && (getText().indexOf(car) >= 0)){
              e.consume();
              return;
        }

          if(car == '-'){
              setText(car+getText());
              e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.isControlDown()){
            e.consume();
            return;
        }

        //consume la tecla inicio, flecha izq o flecha derecha
        if(e.getKeyCode() == 36 || e.getKeyCode() == 37 || e.getKeyCode() == 39){
            e.consume();
            return;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(Color.ORANGE);
        setBorder(new LineBorder(Color.RED));
        selectAll();
        setFocusTraversalKeysEnabled(false);  //desactiva el tabulador

        setFont(font);
    }
    @Override
    public void focusLost(FocusEvent e) {
        setBackground(null);
        setBorder(new LineBorder(null));
    }
}
