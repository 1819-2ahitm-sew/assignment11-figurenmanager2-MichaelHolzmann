package at.htl.figurenmanager2;

import processing.core.PApplet;

public class Circle extends DrawingFigure {

    private Point center;
    private float radius;

    public Circle(Point center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double circumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Kreis mit Radius %.2f: Fläche -> %.2f, Umfang -> %.2f", radius, area(), circumference());
    }

    @Override
    public void draw(PApplet applet) {
        applet.ellipse(center.x, center.y, 2 * radius, 2 * radius);
    }
}
