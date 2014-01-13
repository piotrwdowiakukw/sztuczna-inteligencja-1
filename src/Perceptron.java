import java.util.Random;

public class Perceptron {

    private static final double WSPOLCZYNNIK_UCZACY = 0.1;

    private double waga0, waga1, waga2;

    public double getWaga0() {
        return waga0;
    }
    public double getWaga1() {
        return waga1;
    }
    public double getWaga2() {
    	return waga2;             
    }

    public void setWaga0(double waga0) {
        this.waga0 = waga0;
    };
    public void setWaga1(double waga1) {
        this.waga1 = waga1;
    };
    public void setWaga2(double waga2) {
        this.waga2 = waga2;
    };

    public void Perceptron(double waga0, double waga1, double waga2) {
        setWaga0(waga0);
        setWaga1(waga1);
        setWaga2(waga2);
    }
    
    public Perceptron() {
        Random rand = new Random();
        Perceptron(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
    }

	

    private int licz(double x, double x2){
        double t = x*waga1+x2*waga2 + waga0;
        if(t>=0)
            return 1;
        return 0;
    }

    static public int licz(double x, double x2, double waga0, double waga1, double waga2){
        double t = x*waga1+x2*waga2 + waga0;
        if(t>=0)
            return 1;
        return 0;
    }

    public void ucz(double x, double x2, int oczekiwanaWartosc) {
        int t = licz(x,x2);
        waga1 += WSPOLCZYNNIK_UCZACY * (oczekiwanaWartosc - t) * x;
        waga2 += WSPOLCZYNNIK_UCZACY * (oczekiwanaWartosc - t) * x2;
        waga0 += WSPOLCZYNNIK_UCZACY * (oczekiwanaWartosc - t);
    }
}
