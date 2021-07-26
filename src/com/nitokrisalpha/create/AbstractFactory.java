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

    //抽象工厂
    public abstract static class AbsFactory {
        public abstract Shape getShape(String shape);
    }

    //抽象实现
    public static class AbsShapeFactory extends AbsFactory {
        @Override
        public Shape getShape(String shape) {
            if (shape.matches("circle"))
                return new Circle();
            else if (shape.matches("rectangle"))
                return new Rectangle();
            return null;
        }
    }

    public static class FactoryProducer {
        public static AbsFactory getFactory(String choice) {
            if (choice.matches("shape"))
                return new AbsShapeFactory();
            return null;
        }
    }

    public static void main(String[] args) {
        //观察可以发现，和普通工厂模式相比，在客户端没有出现任何new关键字
        AbsFactory Factory = FactoryProducer.getFactory("shape");
        Shape circle = Factory.getShape("circle");
        circle.say();

    }

}
