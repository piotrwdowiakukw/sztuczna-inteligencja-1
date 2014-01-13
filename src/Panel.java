import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Panel {

	public static void main(String[] args) {
		new Panel();
	}
	
	public Panel() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Sztuczna inteligencja - prosta");
		jFrame.setSize(600,600);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Animacja rysunek = new Animacja();
		Container pane = jFrame.getContentPane();
		pane.setLayout(new GridLayout(1,1));
		
		pane.add(rysunek);
		jFrame.setVisible(true);
		
		
	}
	
}
