package mp3;


import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class displayImageOdds {
	public static void main(String [] args) throws IOException, InterruptedException
	{
		JFrame f = new JFrame();
	
		f.setTitle("MP3Odds");
		MainRun mr = new MainRun();
		
		
		f.add(mr.ev);
		f.setSize(140,160);
		 
		f.addKeyListener(new MoverImage());
		f.setBackground(Color.WHITE);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
