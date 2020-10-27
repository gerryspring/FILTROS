package clemente;

import clemente.PAQUETES.MyCombo;

import javax.swing.*;
import java.awt.*;
public class AplMyCombo extends JFrame {
	MyCombo c,c1;
	public AplMyCombo() {
		HazInterfaz();
	}

	private void HazInterfaz() {
		
//		setLayout(null);
		setLayout(new GridLayout(0,1));
		c=new MyCombo(new String[]{"juan","Miguel","Alicia","Elena","Damaris","javier"});
		c1=new MyCombo(new String[]{"juanXccXX","Miguel","Alicia","Elena","Damaris","javier"});

		c.setLocation(50,50);
		c1.setLocation(50,120);
		
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JButton("***********"),BorderLayout.NORTH);
		add(c1);
		add(c,BorderLayout.SOUTH);
		

		setVisible(true);
		this.update(this.getGraphics());
	}
	public static void main(String [] a) {
		new AplMyCombo();
	
	
	}
}
