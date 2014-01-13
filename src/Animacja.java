import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacja extends JPanel implements ActionListener {
	
	// Definicja Funkcji liniowej do której bêdziemiemy d¹¿yæ. Wed³ug wzoru:
	// Ax + Bx + c = 0
	private double A = 1;
	private double B = -1;
	private double C = 0; // Coœ marnie
	private int counter = 0;
	
	private Perceptron p  = new Perceptron();
	
	// Timer s³u¿¹cy do animacji - nowa klatka co 2 s (2000 ms)
	private Timer timer = new Timer(2000,this);
	
	private static final int PANEL_HEIGHT = 600;
	
	private static final int POINTS_NUMBER = 10;
	private Punkt[] punkt = new Punkt[POINTS_NUMBER];

	//metoda wywo³ywana podczas "tworzenia nowej klatki"
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < POINTS_NUMBER; i++) {
			double x = punkt[i].getX();
			double y = punkt[i].getY();

			int oczekiwana = Perceptron.licz(x, y, C, A, B);
			p.ucz(x, y, oczekiwana);
		}
		repaint();
	}
	
	//Metoda wyznacza pierwszy i ostatni punkt prostej i j¹ rysuje
	public void drawLine(int a, int b, int c, Graphics g) {

		int y1 = PANEL_HEIGHT;
		int y2 = 0;
		int x1 = ((b * y1) + c) / -a;
		int x2 = ((b * y2) + c) / -a;

		g.drawLine(x1, PANEL_HEIGHT - y1, x2, PANEL_HEIGHT - y2);
	}

	//Metoda losuje punkty i wrzuca ich wartoœci do tablicy
	public void assignPoints() {
		Random rand = new Random();
		for (int i = 0; i < POINTS_NUMBER; i++) {
			Punkt punkt;
			int x = rand.nextInt(600);
			int y = rand.nextInt(600);
			if (PANEL_HEIGHT - y < (A * x) + B) {
				punkt = new Punkt(x, y, 1);
			} else {
				punkt = new Punkt(x, y, 0);
			}
			this.punkt[i] = punkt;

		}
	}
	
	public void drawPoints(Graphics g, Color color1, Color color2) {
		for (int i = 0; i < POINTS_NUMBER; i++) {
			if (punkt[i].getPosition() == 1) {
				g.setColor(color1);
			}
			if (punkt[i].getPosition() == 0) {
				g.setColor(color2);
			}
				g.drawOval(punkt[i].getX(), punkt[i].getY(), 3, 3);
		}
	}

	public Animacja() {
		setBackground(Color.ORANGE);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (counter == 0) {
			assignPoints();
		}
		counter ++;
		drawPoints(g, Color.RED, Color.WHITE);
		g.setColor(Color.CYAN);
		g.setColor(Color.BLACK);
		drawLine((int)A, (int)B, (int)C, g);
		g.setColor(Color.GREEN);
		
		int a = (int) p.getWaga1();
		int b = (int) p.getWaga2();
		int c = (int) p.getWaga0();
		System.out.println("waga 0: " + p.getWaga0()+ " waga 1:" + p.getWaga1() + " waga 2:" + p.getWaga2());
		
		//A lub B musi byæ ró¿ne od zera zgodnie z rówaniem prostej		
		if (!((a == 0) && (b == 0))) { 
			drawLine(a, b, c, g);		
		}
		
		//Rozpoczynamy animacje
		timer.start();
		
		
		
	}

	
}
