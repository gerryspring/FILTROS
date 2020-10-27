package clemente.PAQUETES;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
public class MyCombo extends JPanel implements ComponentListener, KeyListener{
	JComboBox c;
	JButton btnOri,btnOrd;
	String [] a;
	JTextComponent Editor;
	public MyCombo(String [] a) {
		this.a=a;
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		
		setLayout(null);
		setSize(250,50);
		this.setBorder(new LineBorder(Color.RED));
		c=new JComboBox(a);
		c.setEditable(true);
		
	
		btnOri=new JButton("Ori");
		btnOrd=new JButton("Ord");
		
		btnOri.setFont(new Font("Tahoma", Font.PLAIN  ,10));
		btnOrd.setFont(new Font("Tahoma", Font.PLAIN  ,10));
		Recalcula();

		
	}
	private void HazEscuchas() {
		this.addComponentListener(this);
		Editor=(JTextComponent)c.getEditor().getEditorComponent();
		Editor.addKeyListener(this);
	}
	@Override
	public void componentResized(ComponentEvent evt) {
		Recalcula();		
		
	}
	private void Recalcula() 	{
		int w=this.getWidth();
		int h=this.getHeight();
		
		c.setLocation((int)(w*0.10),10);
		c.setSize((int)(w*0.60),30);
		add(c);
		int posy=(int)(w*0.60)+(int)(w*0.10)+5;
		btnOri.setLocation(posy,10);
		btnOri.setSize((int)(w*0.20),15);
		add(btnOri);
		btnOrd.setLocation(posy,25);
		btnOrd.setSize((int)(w*0.20),15);
		add(btnOrd);		

	}
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent evt) {
		//System.out.println("se pulso una tecla en la caja del combo, la tecla fue : "+evt.getKeyChar());
		
	}
	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.isControlDown()) {
			evt.consume();
			return;
		}
	}
	@Override
	public void keyReleased(KeyEvent evt) {
		System.out.println("contenido de la caja : "+Editor.getText());
		
	}
}
