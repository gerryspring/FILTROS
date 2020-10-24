package clemente;


import java.awt.*;
import java.awt.event.*;




public class TxtReal extends TxtEntero  implements KeyListener {
	
	public TxtReal(int Tamaño) {
		super(Tamaño);
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// todo lo referente a la parte entera lo debe checar el keypressed del la clase entera
		String texto=getText();
		int hayPunto=texto.indexOf(".");
		
		if(evt.getKeyChar()=='.' && hayPunto==-1) {
			if(texto.length()==0) {
				setText("0.");
				evt.consume();
				return;
			}
			return;
		}	
		if(hayPunto==-1) {
			super.keyTyped(evt);
			return;
		}
		if(evt.getKeyChar()=='.' && hayPunto>-1) {
			evt.consume();
			return;
		}
		// la parte fracci�n
		if("0123456789.".indexOf(evt.getKeyChar())==-1){
			evt.consume();
			return;
		}
		// s�lo se desean dos decimales
		int largoCadena=texto.length();
		if(largoCadena-hayPunto>2) {
			evt.consume();
			Toolkit.getDefaultToolkit().beep();
			return;
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public float getCant() {
		float r=0;
		try {
			r=Float.parseFloat(getText());
		}catch (Exception e) {
			
		}
		return r;
	}

	
}
