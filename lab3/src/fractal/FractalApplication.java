package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
        fractals[0] = new Mountain(new Point(100, 500), new Point(300, 100), new Point(500, 500), 50);
	    new FractalView(fractals, "Fraktaler");
	}
}
