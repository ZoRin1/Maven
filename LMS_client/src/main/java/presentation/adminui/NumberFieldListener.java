package presentation.adminui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumberFieldListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 )) {

		} else {
		e.consume(); 
		}

	}

}
