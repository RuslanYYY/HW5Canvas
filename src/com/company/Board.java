package com.company;

import com.company.model.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;

    private int index = 0;
    private int i = 0;
    private int j = 0;
    private Shape shapeInFocus;
    private Shape shapeToAdd;

    private List<Shape> shapes = new ArrayList<>();
    private List<Shape> inFocusShapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;

        Shape circle = new Circle(gc, 100, 100);
        shapes.add(circle);

        Shape square = new Square(gc, 300, 100);
        shapes.add(square);

        Shape doublecircle = new DoubleCircle(gc, 500, 400);
        shapes.add(doublecircle);

        Shape group = new Group();
        shapes.add(shapes.size(),new Group());
    }

    private void clearScreen() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRoundRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), 0, 0);
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    private void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

            }





    public void keyPressed(KeyEvent event) {
        clearScreen();

        Shape shape = shapes.get(index);

        switch (event.getCode()) {
            case UP:
                shape.moveUP();
                break;
            case RIGHT:
                shape.moveRight();
                break;
            case DOWN:
                shape.moveDown();
                break;
            case LEFT:
                shape.moveLeft();
                break;
            case PAGE_UP:
                previous();
                break;
            case PAGE_DOWN:
                next();
                break;
            case A:
                Shape circle = new Circle(gc, 10, 10);
                shapes.add(circle);
                break;
            case S:
                Shape square = new Square(gc, 10, 10);
                shapes.add(square);
                break;
            case G:
                group();
                break;
            case D:
                Shape doublecircle = new DoubleCircle(gc, 10, 10);
                shapes.add(doublecircle);
            case Q:
                increase();
                break;
            case W:
                decrease();
                break;
            case C:
                copyShape();
                break;
            case DELETE:
                remove();
                clear();
                break;
        }
        drawAll();
    }


    public void increase() {
        for ( Shape shape : shapes ) {
            shape.increase();
        }
    }


    public void decrease() {
        for ( Shape shape : shapes ) {
            shape.decrease();
        }
    }


private void group() {
    if (shapes.get(i) instanceof Circle) {
        Group.group().addShapes(new Circle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        shapes.remove(shapes.get(i));
    }
    if (shapes.get(i) instanceof DoubleCircle) {
        Group.group().addShapes(new DoubleCircle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        shapes.remove(shapes.get(i));
    }
    if (shapes.get(i) instanceof Square) {
        Group.group().addShapes(new Square(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        shapes.remove(shapes.get(i));
    }
    if (i == 0) {
        i++;
    }
    if (i == shapes.size() - 1) {
        i = 0;
    }
    shapes.add(Group.group());
}

    public void copyShape() {
        if (shapes.get(i) instanceof Circle) {
            shapes.add(new Circle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof Square) {
            shapes.add(new Square(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof DoubleCircle) {
            shapes.add(new DoubleCircle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof Group) {
            Group group = (Group) shapes.get(i);
            Group copyGroup = new Group();
            for (int j = 0; j < group.getShapes().size(); j++) {
                if (group.getShapes().get(j) instanceof Circle) {
                    copyGroup.addShapes(new Circle(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
                if (group.getShapes().get(j) instanceof Square) {
                    copyGroup.addShapes(new Square(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
                if (group.getShapes().get(j) instanceof DoubleCircle) {
                    copyGroup.addShapes(new DoubleCircle(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
            }
            shapes.add(copyGroup);
        }
    }


    private void previous() {
        index--;
        if(index < 0) {
            index = shapes.size() - 1;
        }
    }

    private void next() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
    }

    private void remove() {
        if (shapes.size() != 1) {
            shapes.remove(shapes.size() - 1);
            this.gc.clearRect(0, 0, 800, 700);
            drawAll();
            shapes.get(shapes.size() - 1).setInFocus(true);
            System.out.println(shapes.size());
        }
    }

    void toGroup(double mouseX, double mouseY) {
        for (Shape shape : shapes) {

            if (shape.getInFocus()) {
                shapeInFocus = shape;
            }

            if ((mouseX >= shape.getX() && mouseX <= shape.getX() + shape.getDiameter()) &&
                    (mouseY >= shape.getY() && mouseY <= shape.getY() + shape.getDiameter())) {
                shapeToAdd = shape;
                shapeToAdd.setInFocus(true);
            }
        }
        shapes.remove(shapeInFocus);
        shapes.remove(shapeToAdd);
//        shapes.add(group);
        drawAll();

    }

    public void mousePressed(MouseEvent event) {
        if (event.isControlDown()) {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
        }
        if (event.isShiftDown()) {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
        }
    }
}
