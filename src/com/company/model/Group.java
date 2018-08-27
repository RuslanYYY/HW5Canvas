package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shape {

    private List<Shape> shapes = new ArrayList<>();
    private boolean active;
    private static final Group group;

    static {
        group = new Group();
    }
    public int i = 0;

    public void addShapes(Shape shape1, Shape shape2) {
        shapes.add(shape1);
        shapes.add(shape2);

        active = true;
    }

    public static Group group() {
        return group;
    }

    public void addShapes(Shape shape1) {
        shapes.add(shape1);
    }


    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
        }
    }

    @Override
    public void moveUP() {
        for (Shape shape : shapes) {
            shape.moveUP();
        }
    }

    @Override
    public void moveDown() {
        for (Shape shape : shapes) {
            shape.moveDown();
        }
    }

    @Override
    public void increase() {

    }

    @Override
    public void decrease() {

    }



    public void setInFocus(boolean inFocus) {
        if (inFocus){
            this.active =  true;
            for (Shape shape : shapes) {
                shape.setInFocus(true);
            }
        }else {
            this.active = false;
            for (Shape shape : shapes) {
                shape.setInFocus(false);
            }
        }
    }

    @Override
    public boolean getInFocus() {
        for (Shape shape : shapes) {
            shape.getInFocus();
        }
        return this.active;
    }

    @Override
    public double getX() {
        return shapes.get(i).getX();
    }

    @Override
    public double getY() {
        return shapes.get(i).getY();
    }

    public double getX(Shape shape) {
        return shape.getX();
    }

    public double getY(Shape shape) {
        return shape.getY();
    }

    public List<Shape> getShapes() {
        return shapes;
    }


    @Override
    public double getDiameter() {
        return 0;
    }

    @Override
    public void setDiameter(double diameter) {

    }

    @Override
    public void setX(double x) {

    }

    @Override
    public void setY(double y) {

    }


}
