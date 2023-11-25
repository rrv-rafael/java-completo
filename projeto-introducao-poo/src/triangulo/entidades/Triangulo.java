package triangulo.entidades;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private double area;

    public Triangulo() {
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public double getArea() {
        return area;
    }

    public void calcularArea() {
        double p;

        p = (this.lado1 + this.lado2 + this.lado3) / 2;

        this.area = Math.sqrt(p * (p - this.lado1) * (p - this.lado2) * (p - this.lado3));
    }
}
