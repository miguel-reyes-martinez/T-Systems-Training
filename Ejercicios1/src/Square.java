
public class Square extends Shape{
    private float side;

    public Square(float side) {
        this.side = side;
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    public float getPerimeter(){
        float p = 4*side;
        return p;
    }

    public float getArea(){
        float a = (float) Math.pow(side, 2);
        return a;
    }


    public float getSide() {
        return this.side;
    }

    public void setSide(float side) {
        this.side = side;
    }

}
