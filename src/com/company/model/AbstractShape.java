package com.company.model;

import javafx.scene.canvas.GraphicsContext;


public abstract class AbstractShape implements Shape {



    protected double x;
    protected double y;
    protected double diameter = 30;
    protected double maxDiameter = 120;
    protected double minDiameter = 10;
    protected double shift = 10;
    protected GraphicsContext gc;
    private boolean inFocus;


    public AbstractShape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        inFocus = true;
    }

    @Override
    public void moveLeft() {
        x = x - shift;
    }

    @Override
    public void moveRight() {
        x = x + shift;
    }

    @Override
    public void moveUP() {
        y = y - shift;
    }

    @Override
    public void moveDown() {
        y = y + shift;

    }

    @Override
    public void increase() {
        if (diameter < maxDiameter){
            diameter += shift;
        }
    }

    @Override
    public void decrease() {
        if (diameter > minDiameter){
            diameter -= shift;
        }
    }


    public void setInFocus(boolean inFocus) {
        this.inFocus = inFocus;
    }


    public boolean getInFocus() {
        return inFocus;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}


