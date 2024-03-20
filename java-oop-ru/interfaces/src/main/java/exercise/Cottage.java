package exercise;

// BEGIN
public class Cottage implements Home {

    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home another) {
        int x;
        if (this.getArea() > another.getArea()) {
            x = 1;
        } else if (this.getArea() == another.getArea()) {
            x = 0;
        } else {
            x = -1;
        }
        return x;
    }
}
// END
