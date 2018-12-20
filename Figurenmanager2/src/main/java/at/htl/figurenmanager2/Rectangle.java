package at.htl.figurenmanager2;

public class Rectangle extends Figure {

    private Point upperLeftCorner;
    private double length, width;

    public Rectangle(Point upperLeftCorner, double length, double width) {
        this.upperLeftCorner = upperLeftCorner;
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double circumference() {
        return 2 * length + 2 * width;
    }

    public String toString() {
        return String.format("Rechteck mit Länge %.2f und Breite %.2f: Fläche -> %.2f, Umfang -> %.2f", length, width, area(), circumference());
    }

}
