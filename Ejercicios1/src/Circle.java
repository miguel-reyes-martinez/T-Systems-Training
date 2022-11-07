public class Circle extends Shape{
    private float radius;


    public Circle(float radius) {
        this.radius = radius;
        this.perimeter = getPerimeter();
        this.area = getArea();
    }

    public float getPerimeter(){
        float p = (float) (2* Math.PI * radius);
        return p;
    }

    public float getArea(){
        float a = (float) (Math.PI * Math.pow(radius, 2));
        return a;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

}
