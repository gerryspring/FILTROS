package Componentes;

import javax.swing.*;
import java.awt.*;

public class StandardLabel extends JLabel {
    Font font;

    public StandardLabel(String text, int size, int horizontalAlignment){
        super(text,horizontalAlignment);
        font = new Font("Tahoma",Font.BOLD,size);
        setFont(font);
    }
}
