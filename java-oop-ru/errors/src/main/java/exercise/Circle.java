package exercise;

// BEGIN
public class Circle {
    Point point;
    int rad;
    Circle(Point point, int rad) {
        this.point = point;
        this.rad = rad;
    }
    public int getRadius() {
        return rad;
    }
    public float getSquare() throws NegativeRadiusException {
        if (rad < 0) throw new NegativeRadiusException("Radius < 0");
        return (float) Math.PI * rad * rad;
    }
}
// END
