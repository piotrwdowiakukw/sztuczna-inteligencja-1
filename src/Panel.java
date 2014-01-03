import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class Panel {

	public static void main(String[] args) {
		new Panel();
	}
	
	public Panel() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Sztuczna inteligencja 1");
		jFrame.setSize(400,300);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Rysunek rysunek = new Rysunek();
		Container pane = jFrame.getContentPane();
		pane.setLayout(new GridLayout(1,1));
		
		pane.add(rysunek);
		jFrame.setVisible(true);
	}
	
}
