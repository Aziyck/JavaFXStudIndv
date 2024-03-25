package ceiti.me.example.javafxfirstprog.week7.OblongPckg;

public class Oblong {
    Double length;
    Double height;

    public Oblong(Double length, Double height) {
        this.length = length;
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double calculateArea(){
        return length * height;
    }

    public Double calculatePerimeter(){
        return length*2 + height*2;
    }
}
