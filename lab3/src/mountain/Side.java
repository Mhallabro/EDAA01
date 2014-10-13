package mountain;

public class Side {
    private Point startPoint, endPoint, midPoint;

    public Side(Point a, Point b, Point ab){
        this.startPoint = a;
        this.endPoint = b;
        this.midPoint = ab;
    }

    public boolean equals(Point a, Point b){
        return startPoint.equals(a) && endPoint.equals(b);
    }

    public Point getMidPoint(){
        return midPoint;
    }
}
