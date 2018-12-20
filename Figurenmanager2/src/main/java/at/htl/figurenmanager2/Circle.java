package at.htl.figurenmanager2;

public class Circle extends Figure {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double circumference() {
        return 2 * radius * Math.PI;
    }

    public String toString() {
        return String.format("Kreis mit Radius %.2f: Fläche -> %.2f, Umfang -> %.2f", radius, area(), circumference());
    }

}
