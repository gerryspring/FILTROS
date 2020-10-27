package Componentes.JComboBox;

import javax.swing.*;
import java.awt.*;

public class StandardComboBox extends JComboBox {
    Font font;
    public  StandardComboBox(){
        setPreferredSize(new Dimension(150,20));
        font = new Font("Tahoma",Font.BOLD,14);
        setFont(font);
        this.setEnabled(false);
    }


}
