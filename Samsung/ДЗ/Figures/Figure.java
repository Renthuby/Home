 abstract class Figure {
    float x;
    float y;

    Figure(float x, float y) {
        this.x = x;
        this.y = y;
    }

    abstract  float getArea();
    abstract  float getPerimeter();

}

class Rectangle extends Figure implements Moveable{
    float height;
    float width;

    Rectangle(float x, float y, float height, float width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    float getArea() {
        return this.height * this.width;
    }

    @Override
    float getPerimeter() {
        return (this.height + this.width) * 2;
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(float koeff) {
        this.height *= koeff;
        this.width *= koeff;
    }

    @Override
    public String toString() {
        return "Rectangle\n" + "Center: (" + (x + width/2) + ", " + (y + height/2) + ")\n" + "Height: " + height + "\n" + "Width: " + width + "\n";
    }
}

class Circle extends Figure implements Moveable{
    float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    float getPerimeter() {
        return (float) (2 * radius * Math.PI);
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(float koeff) {
        this.radius *= koeff;
    }

    @Override
    public String toString() {
        return "Circle\n" + "Center: (" + x + ", " + y + ")\n" + "Radius: " + radius;
    }
}

interface Moveable{
    void move(float dx, float dy);
    void resize(float koeff);
}