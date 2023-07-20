package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;
    double wholeArea;
    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        this.wholeArea = area + balconyArea;
    }
    @Override
    public double getArea() {
        return wholeArea;
    }

    @Override
    public int compareTo(Home another) {
        if (wholeArea > another.getArea()) {
            return 1;
        } else if (wholeArea < another.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Квартира площадью " + wholeArea
                + " метров на " + floor + " этаже";
    }
}
// END
