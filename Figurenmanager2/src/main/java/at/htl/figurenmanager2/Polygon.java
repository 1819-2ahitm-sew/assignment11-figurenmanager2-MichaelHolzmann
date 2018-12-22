package at.htl.figurenmanager2;

import processing.core.PApplet;

import java.util.ArrayList;

public class Polygon extends DrawingFigure {

    private ArrayList<Point> corners;

    public Polygon(ArrayList<Point> corners) {
        this.corners = corners;
    }

    @Override
    public double area() {
        double area = 0;

        if (corners.size() < 3) {
            return 0.0;
        }

        for (int i = 0; i < corners.size(); i++) {
            area += (corners.get(i).y + corners.get((i + 1) % corners.size()).y) * (corners.get(i).x - corners.get((i + 1) % corners.size()).x);
        }

        return Math.abs(area / 2.0);
    }

    @Override
    public double circumference() {
        double circumference = 0;
        double xDiff, yDiff;

        if (corners.size() < 3) {
            return 0.0;
        }

        for (int i = 0; i < corners.size(); i++) {
            xDiff = corners.get((i + 1) % corners.size()).x - corners.get(i).x;
            yDiff = corners.get((i + 1) % corners.size()).y - corners.get(i).y;
            circumference += Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        }

        return circumference;
    }

    @Override
    public String toString() {
        return String.format("Polygon %d Eckpunkten: Fläche -> %.2f, Umfang -> %.2f", corners.size(), area(), circumference());
    }

    @Override
    public void draw(PApplet applet) {
        for (int i = 0; i < corners.size(); i++) {
            applet.line(corners.get(i).x,
                    corners.get(i).y,
                    corners.get((i + 1) % corners.size()).x,
                    corners.get((i + 1) % corners.size()).y);
        }
    }
}
