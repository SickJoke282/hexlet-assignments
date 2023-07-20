package exercise;

// BEGIN
public class Segment {
    public Point beginPoint;
    public Point endPoint;
    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }
    public Point getBeginPoint() {
        return beginPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        return new Point(
                (beginPoint.x + endPoint.x) / 2,
                (beginPoint.y + endPoint.y) / 2
        );
    }
}
// END
