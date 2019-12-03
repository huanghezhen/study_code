package hhz.ocp;

/**
 * huanghz
 * 2019/12/3 下午4:35
 */
public class OCP1 {
    public static void main(String[] args) throws Exception {
        
    }
}


class GraphicEditor {
    public void drawShape(Shape shape) {
        if (shape.mType == 1) {
            drawRectangle(shape);
        } else if (shape.mType == 2) {
            drawCircle(shape);
        }
    }

    public void drawRectangle(Shape shape) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape shape) {
        System.out.println("圆形");
    }
}


class Shape {
    int mType;
}


class Rectangle extends Shape {
    Rectangle() {
        mType = 1;
    }
}


class Circle extends Shape {
    Circle() {
        mType = 2;
    }
}