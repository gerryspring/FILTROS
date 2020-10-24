package Componentes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextField extends JTextField implements KeyListener {
   protected int tamaño;
   Font fuente;
   LineBorder lineborder;

    public TextField(int tamaño){
        this.tamaño = tamaño;
        fuente = new Font("Tahoma",Font.BOLD,16);
        lineborder = new LineBorder(Color.BLACK);
        setBorder(lineborder);
        setFont(fuente);

        Listeners();
    }

    private void Listeners(){
        addKeyListener(this);
    }

    public static void main(String[] args) {
        TextField textField = new TextField(50);
        JOptionPane.showMessageDialog(null, textField);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char car = e.getKeyChar();

        if(getText().length() == tamaño) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if("0123456789-.,{}+´¿'|<_:;[]*¨¡?=)(/&%$#\"!°>".indexOf(car) != -1 ) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
