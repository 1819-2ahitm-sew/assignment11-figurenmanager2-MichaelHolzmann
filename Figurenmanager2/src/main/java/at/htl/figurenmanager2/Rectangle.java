package at.htl.figurenmanager2;

import processing.core.PApplet;

public class Rectangle extends DrawingFigure {

    private Point upperLeftCorner;
    private float length, width;

    public Rectangle(Point upperLeftCorner, float length, float width) {
        this.upperLeftCorner = upperLeftCorner;
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double circumference() {
        return 2 * length + 2 * width;
    }

    @Override
    public String toString() {
        return String.format("Rechteck mit Länge %.2f und Breite %.2f: Fläche -> %.2f, Umfang -> %.2f", length, width, area(), circumference());
    }

    @Override
    public void draw(PApplet applet) {
        applet.rect(upperLeftCorner.x, upperLeftCorner.y, length, width);
    }

}
