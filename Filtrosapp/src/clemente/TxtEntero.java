package clemente;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
public class TxtEntero extends JTextField implements KeyListener, FocusListener{
	protected int Tamaño; // representa el n�mero de d�gitos
	Font Fuente,FuenteO;

	public TxtEntero(int Tamaño) {
		this.Tamaño = Tamaño;
		HazEscuchadores();
		FuenteO=this.getFont();
		Fuente=new Font("Tahoma",Font.BOLD,20);
		
	}
	private void HazEscuchadores() {
		addKeyListener(this);
		addFocusListener(this);
	}
	public long getCantidad() {
		long res=0;
		try {
			res=Long.parseLong(getText());
		} catch (Exception e) {
			res=0;
		}
		return res;
	}
	@Override
	public void keyTyped(KeyEvent evt) {

		char car= evt.getKeyChar();
	 	
	 	if(getText().length()== Tamaño) {
	 		evt.consume();
	 		Toolkit.getDefaultToolkit().beep();
	 		return;
	 	}
//		if( !  (evt.getKeyChar()<48 || evt.getKeyChar()>'9'  || evt.getKeyChar=='-' )  ) {
//	 	if( !( Character.isDigit(evt.getKeyChar()) || evt.getKeyChar()>'-' )    ) {
	 	if("0123456789-".indexOf(car) == -1 ) {
	 		evt.consume();
			return;
		}
	 	if(car=='-' && ( getText().indexOf(car) >=0   )  ){ // se puls� el -, pero ya un - tecleado
	 		evt.consume();
			return;
	 	}
	 	if(car=='-') {
	 		setText(car+getText());
	 		evt.consume();
	 	}
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.isControlDown()){
			evt.consume();
			return;
		}
		//consume la tecla Inicio,flecha izq o flecha der
		if(evt.getKeyCode()==36 ||evt.getKeyCode()==37 || evt.getKeyCode()==39){
			evt.consume();
			return;
		}	
	}

	@Override
	public void keyReleased(KeyEvent evt) {

		
	}
	@Override
	public void focusGained(FocusEvent evt) {
				
		setBackground(Color.YELLOW);
		setBorder(new LineBorder(Color.RED));
		selectAll();
		setFocusTraversalKeysEnabled(false);
		
		setFont(Fuente);
		
	}

	@Override
	public void focusLost(FocusEvent evt) {
		setBackground(null);
		setBorder(new LineBorder(Color.gray));
		setFont(FuenteO);		
	}
}


