package Componentes;

import javax.swing.*;
import java.awt.*;

public class PanelGrid extends JPanel {
   protected GridLayout grid;
    public PanelGrid(int rows,int col){
        grid = new GridLayout(rows,col);
        grid.setHgap(5);
        grid.setVgap(5);
        setLayout(grid);
    }
}
