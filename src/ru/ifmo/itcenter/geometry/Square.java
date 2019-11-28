package ru.ifmo.itcenter.geometry;

/**
 * Created by Roman Petrov
 * Квадрат.
 * Задается на плоскости левой нижней точкой и длиной строны.
 *
 * Может использоваться в коллекциях в качестве ключей или значений
 */
public abstract class Square {


    protected Point basePoint;
    protected double w;

    public Square(Point leftBottom, double w) {
        this.basePoint = leftBottom;
        this.w = w;
    }

    // вернуть площадь квадрата
    public abstract double getArea();

    // длина строны
    public abstract double getWidth();

    // не линия или точка ли это
    public abstract boolean isDegenerate();

    // точка another попадает в квадрат или нет?
    public abstract boolean isInSquare(Point another);

    /*
        Возвращает экземпляр Square
     */
    public static Square getSquare(Point topBottom, double w) {
        return null;
    }

}
