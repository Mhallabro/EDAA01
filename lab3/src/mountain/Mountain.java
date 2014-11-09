package mountain;

import java.util.LinkedList;
import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
	private Point a, b, c;
	private double dev;
	private LinkedList<Side> sides;

	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		sides = new LinkedList<Side>();
	}

	@Override
	public String getTitle() {
		return "Mountain";
	}

	@Override
	public void draw(TurtleGraphics g) {
		drawTriangle(g, a, b, c, order, dev);
	}

	private void drawTriangle(TurtleGraphics g, Point a, Point b, Point c,
			int order, double dev) {
		if (order == 0) {
			g.moveTo(a.getX(), a.getY());
			g.forwardTo(b.getX(), b.getY());
			g.forwardTo(c.getX(), c.getY());
			g.forwardTo(a.getX(), a.getY());
		} else {
			Point ab = getMidPoint(a, b, dev);
			Point bc = getMidPoint(b, c, dev);
			Point ac = getMidPoint(a, c, dev);
			drawTriangle(g, a, ab, ac, order - 1, dev / 2);
			drawTriangle(g, ab, b, bc, order - 1, dev / 2);
			drawTriangle(g, ac, bc, c, order - 1, dev / 2);
			drawTriangle(g, ab, ac, bc, order - 1, dev / 2);
		}
	}
    
	private Point getMidPoint(Point a, Point b, double dev) {
		for (Side s : sides) {
			if (s.equals(a, b)) {
				Point midPoint = s.getMidPoint();
				sides.remove(s);
				return midPoint;
			}
		}
		double x = (a.getX() + b.getX()) / 2;
		double shift = RandomUtilities.randFunc(dev);
		double y = ((a.getY() + b.getY()) / 2) + shift;
		Point midPoint = new Point(x, y);
		sides.add(new Side(a, b, midPoint));
		return midPoint;
	}
}