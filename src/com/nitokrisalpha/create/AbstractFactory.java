package com.nitokrisalpha.create;

public class AbstractFactory {
    //形状工厂
    public interface ShapeFactory {
        Shape getShape();
    }

    //形状标准
    public interface Shape {
        void say();
    }

    //形状标准的长方形实现
    public static class Rectangle implements Shape {

        @Override
        public void say() {
            System.out.println("Rectangle");
        }
    }

    //圆形实现
    public static class Circle implements Shape {

        @Override
        public void say() {
            System.out.println("Circle");
        }
    }

    //长方形生产工厂
    public static class RectangleFactory implements ShapeFactory {
        @Override
        public Shape getShape() {
            return new Rectangle();
        }
    }

    //圆形工厂
    public static class CircleFactory implements ShapeFactory {

        @Override
        public Shape getShape() {
            return new Circle();
        }
    }

    //抽象工厂
    public static class Factory {
        public static ShapeFactory getShapeFactory(String shape) {
            if (shape.matches("rectangle"))
                return new RectangleFactory();
            else if (shape.matches("circle"))
                return new CircleFactory();
            else
                return null;
        }

    }

    public static void main(String[] args) {
        //观察可以发现，和普通工厂模式相比，在客户端没有出现任何new关键字
        ShapeFactory factory = Factory.getShapeFactory("rectangle");
        Shape rectangle = factory.getShape();
        rectangle.say();
        factory = Factory.getShapeFactory("circle");
        Shape circle = factory.getShape();
        circle.say();
    }

}
