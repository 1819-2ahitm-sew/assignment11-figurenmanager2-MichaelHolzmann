package at.htl.figurenmanager2;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends PApplet {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Figure> figures = new ArrayList<Figure>();
    private static boolean exit = false;

    public static void main(String[] args) {
        PApplet.main("at.htl.figurenmanager2.Main", args);

        int menuSelection;

        do {
            System.out.println("Programmmenü:");
            System.out.println("-------------------------------------");
            System.out.println("<1> Kreis hinzufügen");
            System.out.println("<2> Ellipse hinzufügen");
            System.out.println("<3> Quadrat hinzufügen");
            System.out.println("<4> Rechteck hinzufügen");
            System.out.println("<5> Polygon hinzufügen");
            System.out.println("<6> Datenanzeige nach Umfang sortiert");
            System.out.println("<7> Datenanzeige nach Fläche sortiert");
            System.out.println("<8> Programmende");
            System.out.println("-------------------------------------");

            System.out.print("Auswahl (1-8): ");
            menuSelection = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (menuSelection) {
                case 1:
                    figures.add(createCircle());
                    break;
                case 2:
                    figures.add(createEllipse());
                    break;
                case 3:
                    figures.add(createSquare());
                    break;
                case 4:
                    figures.add(createRectangle());
                    break;
                case 5:
                    figures.add(createPolygon());
                    break;
                case 6:
                    printFiguresSortedByCircumference(figures);
                    break;
                case 7:
                    printFiguresSortedByArea(figures);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Ungültige Auswahl: Geben Sie eine Zahl zwischen 1 und 8 ein.");
            }

            System.out.println();

        } while (menuSelection != 8);
    }

    private static Circle createCircle() {
        System.out.println("Kreis erstellen:");
        System.out.println("-------------------------------------");
        System.out.print("x-Koordinate (Mittelpunkt): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (Mittelpunkt): ");
        float y = scanner.nextFloat();

        System.out.print("Radius: ");
        float radius = scanner.nextFloat();

        return new Circle(new Point(x, y), radius);
    }

    private static Ellipse createEllipse() {
        System.out.println("Ellipse erstellen:");
        System.out.println("-------------------------------------");
        System.out.print("x-Koordinate (Mittelpunkt): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (Mittelpunkt): ");
        float y = scanner.nextFloat();

        System.out.print("Hauptachse: ");
        float majorAxis = scanner.nextFloat();

        System.out.print("Nebenachse: ");
        float minorAxis = scanner.nextFloat();

        return new Ellipse(new Point(x, y), majorAxis, minorAxis);
    }

    private static Square createSquare() {
        System.out.println("Quadrat erstellen:");
        System.out.println("-------------------------------------");
        System.out.print("x-Koordinate (Eckpunkt links oben): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (Eckpunkt links oben): ");
        float y = scanner.nextFloat();

        System.out.print("Länge: ");
        float length = scanner.nextFloat();

        return new Square(new Point(x, y), length);
    }

    private static Rectangle createRectangle() {
        System.out.println("Rechteck erstellen:");
        System.out.println("-------------------------------------");
        System.out.print("x-Koordinate (Eckpunkt links oben): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (Eckpunkt links oben): ");
        float y = scanner.nextFloat();

        System.out.print("Länge: ");
        float length = scanner.nextFloat();

        System.out.print("Breite: ");
        float width = scanner.nextFloat();

        return new Rectangle(new Point(x, y), length, width);
    }

    private static Polygon createPolygon() {
        ArrayList<Point> corners = new ArrayList<>();
        float x, y;
        int input;

        System.out.println("Polygon erstellen:");
        System.out.println("-------------------------------------");


        for (int i = 1; i <= 3; i++) {
            System.out.printf("x-Koordinate (%d. Eckpunkt): ", i);
            x = scanner.nextFloat();

            System.out.printf("y-Koordinate (%d. Eckpunkt): ", i);
            y = scanner.nextFloat();
            scanner.nextLine();

            corners.add(new Point(x, y));
        }

        System.out.println("<1> Weiteren Eckpunkt hinzufügen");
        System.out.println("<2> Eingabe der Eckpunkte beenden");
        System.out.print("Auswahl (1-2): ");
        input = scanner.nextInt();

        int count = 3;
        while (input == 1) {
            count++;

            System.out.printf("x-Koordinate (%d. Eckpunkt): ", count);
            x = scanner.nextFloat();

            System.out.printf("y-Koordinate (%d. Eckpunkt: ", count);
            y = scanner.nextFloat();
            scanner.nextLine();

            corners.add(new Point(x, y));

            System.out.println("<1> Weiteren Eckpunkt hinzufügen");
            System.out.println("<2> Eingabe der Eckpunkte beenden");
            System.out.print("Auswahl (1-2): ");
            input = scanner.nextInt();
        }

        return new Polygon(corners);
    }

    private static void printFiguresSortedByArea(ArrayList<Figure> figures) {
        Figure tmp;

        for (int i = 0; i < figures.size() - 1; i++) {
            for (int j = i + 1; j < figures.size(); j++) {
                if (figures.get(j).area() < figures.get(i).area()) {
                    tmp = figures.get(i);
                    figures.set(i, figures.get(j));
                    figures.set(j, tmp);
                }
            }
        }

        for (Figure f : figures) {
            System.out.println(f);
        }

        System.out.print("Drücken Sie <Enter> um fortzufahren.");
        scanner.nextLine();
    }

    private static void printFiguresSortedByCircumference(ArrayList<Figure> figures) {
        Figure tmp;

        for (int i = 0; i < figures.size() - 1; i++) {
            for (int j = i + 1; j < figures.size(); j++) {
                if (figures.get(j).circumference() < figures.get(i).circumference()) {
                    tmp = figures.get(i);
                    figures.set(i, figures.get(j));
                    figures.set(j, tmp);
                }
            }
        }

        for (Figure f : figures) {
            System.out.println(f);
        }

        System.out.print("Drücken Sie <Enter> um fortzufahren.");
        scanner.nextLine();
    }

    public void settings() {
        size(2000, 1000);
    }

    public void setup() {
        noFill();
        strokeWeight(3);
    }

    public void draw() {
        background(g.backgroundColor);

        if (exit) {
            exit();
        } else {
            for (Figure figure : figures) {
                if (figure instanceof DrawingFigure) {
                    ((DrawingFigure) figure).draw(this);
                }
            }
        }
    }

}
