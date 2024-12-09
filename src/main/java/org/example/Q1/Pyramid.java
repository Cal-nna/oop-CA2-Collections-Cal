package org.example.Q1;

public class Pyramid implements IMeasurableContainer {
    private double length;
    private double sideLength;
    private double weight;

    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "length=" + length +
                ", sideLength=" + sideLength +
                ", weight=" + weight +
                '}';
    }

    @Override
    public double weight() {
        // Simply return the weight of the pyramid
        return this.weight;
    }

    @Override
    public double rectangularVolume() {
        // Calculate the rectangular volume of a pyramid:
        // Volume = (1/3) * Base Area * Height
        // Assuming "length" is the base length and "sideLength" is the height
        double baseArea = length * length;
        return (1.0 / 3) * baseArea * sideLength;
    }
}
