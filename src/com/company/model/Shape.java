package com.company.model;

public interface Shape {
    void draw();
    void moveLeft();
    void moveRight();
    void moveUP();
    void moveDown();
    void increase();
    void decrease();
    void setInFocus(boolean inFocus);
    boolean getInFocus();
    double getX();
    double getY();
    double getDiameter();
    void setDiameter(double diameter);
    void setX(double x);
    void setY(double y);
}
