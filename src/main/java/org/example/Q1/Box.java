package org.example.Q1;

public class Box implements IMeasurableContainer {
    private double length;
    private double width;
    private double depth;
    private double weight;

    public Box(double width, double length, double depth, double weight) {
        this.width = width;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Box{" +
                "length=" + length +
                ", width=" + width +
                ", depth=" + depth +
                ", weight=" + weight +
                '}';
    }

    @Override
    public double weight() {
        // Simply return the weight of the box
        return this.weight;
    }

    @Override
    public double rectangularVolume() {
        // Volume of a rectangular box: length × width × depth
        return length * width * depth;
    }
}
