package com.qa;

public abstract class Shape {
    private String name;
    private String color;
    private double x, y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Shape(String name, String color, double x, double y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();
    public abstract Point getCenterPoint();
}
