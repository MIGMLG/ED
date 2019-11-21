package demo;

public class Car implements Comparable {

    private String marca;
    private String modelo;
    private int year;

    public Car(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Object o) {
        try {
            Car tmp = (Car) o;
            if (this.year < tmp.year) {
                return -1;
            } else if (this.year == tmp.year) {
                return 0;
            }
            return 1;
        } catch (Exception ex) {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", year=" + year +
                '}';
    }
}
