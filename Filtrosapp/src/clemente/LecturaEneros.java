package clemente;

//import paquete105.*;// este paquete est� a partir del c:\paquete105

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class LecturaEneros extends JFrame implements ActionListener{
	TxtEntero txtEdad,txtEstatura,txtPeso;
	public LecturaEneros() {
		super("usando comoponente de lectura enteros");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,5,5));
		
		txtEdad=new TxtEntero(5);
		txtEstatura=new TxtEntero(8);
		txtPeso=new TxtEntero(6);
		
		add(new JLabel("Edad",JLabel.RIGHT));
		add(txtEdad);
		
		add(new JLabel("Estatura",JLabel.RIGHT));
		add(txtEstatura);
		
		add(new JLabel("Peso",JLabel.RIGHT));
		add(txtPeso);
		
		setVisible(true);
		
		
	}
	private void HazEscuchas() {
		txtEdad.addActionListener(this);
		txtEstatura.addActionListener(this);
		txtPeso.addActionListener(this);

	}
	
	public static void main(String [] a) {
		new LecturaEneros();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==txtEdad) {
			long edadPersona=txtEdad.getCantidad();
			if(edadPersona < 18 || edadPersona>60) {
				JOptionPane.showMessageDialog(null,
						"Rango permitido del 18 a 60 a�os", " Edad capturada -->"+txtEdad.getCantidad(), 
						JOptionPane.ERROR_MESSAGE);	
				return;
				
			}
			txtEstatura.requestFocus();
			return;
		}
		if(evt.getSource()==txtEstatura) {
			long estaturaPersona=txtEstatura.getCantidad();
			if(estaturaPersona < 160 || estaturaPersona>190) {
				JOptionPane.showMessageDialog(null,
						"Rango permitido del 160 a 190 cms", " Estatura capturada -->"+txtEstatura.getCantidad(), 
						JOptionPane.ERROR_MESSAGE);	
				return;
				
			}
			txtPeso.requestFocus();
			return;			
		}
		if(evt.getSource()==txtPeso) {
			long pesoPersona=txtPeso.getCantidad();
			if(pesoPersona < 60 || pesoPersona>80) {
				JOptionPane.showMessageDialog(null,
						"Rango permitido del 60 a 80 kg", " kg capturada -->"+txtPeso.getCantidad(), 
						JOptionPane.ERROR_MESSAGE);	
				
				return;
			}
//			btnGrabar.requestFocus();
			txtEdad.requestFocus();
			return;			
		}
		
	}

}
