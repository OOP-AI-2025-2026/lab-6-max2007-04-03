package org.example.test2;

public class Point implements Movable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void moveTo(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return "Point at (" + x + ", " + y + ")";
    }
}