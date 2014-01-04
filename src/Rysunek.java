import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Rysunek extends JPanel {
	
	public Rysunek() {
		setBackground(Color.ORANGE);		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Mój komentarz który chcia³bym dodaæ mimo wszystko
		g.drawLine(100,100,200,200);
		g.drawLine(200,200,300,300);
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 400, 300);
	}

}
