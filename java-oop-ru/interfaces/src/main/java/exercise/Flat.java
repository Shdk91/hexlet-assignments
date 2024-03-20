package exercise;

// BEGIN
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.area+this.balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        int x;
        if (this.getArea()>another.getArea()) {
            x = 1;
        } else if (this.getArea() == another.getArea()) {
            x = 0;
        } else {
            x = -1;
        }
        return x;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
