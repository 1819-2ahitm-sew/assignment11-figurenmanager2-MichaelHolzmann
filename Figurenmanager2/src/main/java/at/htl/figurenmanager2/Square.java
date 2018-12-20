package at.htl.figurenmanager2;

public class Square extends Figure {

    private Point upperLeftCorner;
    private float length;

    public Square(Point upperLeftCorner, float length) {
        this.upperLeftCorner = upperLeftCorner;
        this.length = length;
    }

    public double area() {
        return length * length;
    }

    public double circumference() {
        return 4 * length;
    }

    public String toString() {
        return String.format("Quadrat mit Länge %.2f: Fläche -> %.2f, Umfang -> %.2f", length, area(), circumference());
    }

}