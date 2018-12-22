package at.htl.figurenmanager2;

import processing.core.PApplet;

public class Ellipse extends DrawingFigure {

    private Point center;
    private float majorAxis, minorAxis;

    public Ellipse(Point center, float majorAxis, float minorAxis) {
        this.center = center;
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double area() {
        return majorAxis / 2 * minorAxis / 2 * Math.PI;
    }

    @Override
    public double circumference() {
        return (majorAxis / 2 + minorAxis / 2) * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Ellipse mit Hauptachse %.2f und Nebenachse %.2f: Fläche -> %.2f, Umfang -> %.2f", majorAxis, minorAxis, area(), circumference());
    }

    @Override
    public void draw(PApplet applet) {
        applet.ellipse(center.x, center.y, majorAxis, minorAxis);
    }
}
