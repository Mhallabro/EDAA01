package fractal;

import mountain.Mountain;
import mountain.Point;
import koch.Koch;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
		fractals[0] = new Mountain(new Point(100, 490), new Point(350, 100), new Point(500, 510), 30);
	    new FractalView(fractals, "Fraktaler");
	}

}
