package at.htl.figurenmanager2;

import processing.core.PApplet;

public class Square extends DrawingFigure {

    private Point upperLeftCorner;
    private float length;

    public Square(Point upperLeftCorner, float length) {
        this.upperLeftCorner = upperLeftCorner;
        this.length = length;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public double circumference() {
        return 4 * length;
    }

    @Override
    public String toString() {
        return String.format("Quadrat mit Länge %.2f: Fläche -> %.2f, Umfang -> %.2f", length, area(), circumference());
    }

    @Override
    public void draw(PApplet applet) {
        applet.rect(upperLeftCorner.x, upperLeftCorner.y, length, length);
    }
}