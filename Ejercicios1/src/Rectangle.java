public class Rectangle extends Shape{
    private float base, height;


    public Rectangle(float base, float height) {
        this.base = base;
        this.height = height;
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    public float getPerimeter(){
        float p = (2*base) + (2*height);
        return p;
    }

    public float getArea(){
        float a = base*height;
        return a;
    }


    public float getBase() {
        return this.base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
