package at.htl.figurenmanager2;

public class Rectangle extends Figure {

    private Point upperLeftCorner;
    private float length, width;

    public Rectangle(Point upperLeftCorner, float length, float width) {
        this.upperLeftCorner = upperLeftCorner;
        this.length = length;
        this.width = width;
    }

    public Point getUpperLeftCorner() {
        return upperLeftCorner;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
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
