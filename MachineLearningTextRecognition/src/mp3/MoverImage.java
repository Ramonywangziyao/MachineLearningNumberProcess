package mp3;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoverImage implements KeyListener {
	static int imgNumber = 0;
	static double mul = 50;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	imgNumber-=1;
        	if(imgNumber<0)
        		imgNumber=9;
            
        }
        else
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           	imgNumber+=1;
           	if(imgNumber>9)
           		imgNumber=0;	
           	
            }	
        else
            if (e.getKeyCode() == KeyEvent.VK_UP) {
               	mul+=1;
               	
               	
                }
            else
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                   	mul-=1;
                   	if(mul<=0)
                   		mul=1;	
                   	
                    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
