package org.example.Q1;

public class Cylinder implements IMeasurableContainer{
    private double height;
    private double weight;
    private double diameter;

    public Cylinder(double height, double weight, double diameter) {
        this.height = height;
        this.weight = weight;
        this.diameter = diameter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", weight=" + weight +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public double weight() {
        return 0;
    }

    @Override
    public double rectangularVolume() {
        return 0;
    }
}
