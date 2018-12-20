package at.htl.figurenmanager2;

import java.util.ArrayList;

public class Polygon extends Figure {
    private ArrayList<Point> corners;

    public Polygon(ArrayList<Point> corners) {
        this.corners = corners;
    }

    public double area() {
        double area = 0;

        if (corners.size() < 3) {
            return 0.0;
        }

        for (int i = 0; i < corners.size(); i++) {
            area += (corners.get(i).y + corners.get((i+1) % corners.size()).y) * (corners.get(i).x - corners.get((i+1) % corners.size()).x);
        }
        
        return Math.abs(area / 2.0);
    }

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

    public String toString() {
        return String.format("Polygon %d Eckpunkten: Fläche -> %.2f, Umfang -> %.2f", corners.size(), area(), circumference());
    }


}
