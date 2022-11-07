public class Triangle extends Shape{
    private float base, height;


    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
        this.area = getArea();
    }

    public float getArea(){
        float a = (base*height)/2;
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
