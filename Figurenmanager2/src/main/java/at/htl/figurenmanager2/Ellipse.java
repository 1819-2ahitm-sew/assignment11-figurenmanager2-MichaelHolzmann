package at.htl.figurenmanager2;

public class Ellipse extends Figure {

    private Point center;
    private float majorAxis, minorAxis;

    public Ellipse(Point center, float majorAxis, float minorAxis) {
        this.center = center;
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    public double area() {
        return majorAxis / 2 * minorAxis / 2 * Math.PI;
    }

    public Point getCenter() {
        return center;
    }

    public float getMajorAxis() {
        return majorAxis;
    }

    public float getMinorAxis() {
        return minorAxis;
    }

    public double circumference() {
        return (majorAxis / 2 + minorAxis / 2) * Math.PI;
    }

    public String toString() {
        return String.format("Ellipse mit Hauptachse %.2f und Nebenachse %.2f: Fläche -> %.2f, Umfang -> %.2f", majorAxis, minorAxis, area(), circumference());
    }

}
