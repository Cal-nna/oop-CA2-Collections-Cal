package org.example.Q1;
import java.util.List;

/**
 *  Your Name: Callum Hanna
 *  Class Group: SD2A
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1");

        // create container here....
        ContainerManager shape = new ContainerManager();

        // Add containers
        shape.add(new Box(2, 3, 4, 50));
        shape.add(new Cylinder(5, 2, 20));
        shape.add(new Pyramid(6, 4, 30));

        // Calculate total weight and rectangular volume
        System.out.println("Total Weight: " + shape.totalWeight() +"kg");
        System.out.println("Total Rectangular Volume: " + shape.totalRectangularVolume() +"cm³");

        // Display all containers
        List<IMeasurableContainer> containers = shape.getAllContainers();
        for (IMeasurableContainer container : containers) {
            if (container instanceof Box) {
                Box box = (Box) container;
                System.out.println("Box - Length: " + box.getLength() + ", Width: " + box.getWidth()
                        + ", Depth: " + box.getDepth() + ", Weight: " + box.getWeight());
            } else if (container instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) container;
                System.out.println("Cylinder - Height: " + cylinder.getHeight() + ", Diameter: "
                        + cylinder.getDiameter() + ", Weight: " + cylinder.getWeight());
            } else if (container instanceof Pyramid) {
                Pyramid pyramid = (Pyramid) container;
                System.out.println("Pyramid - Length: " + pyramid.getLength() + ", Side Length: "
                        + pyramid.getSideLength() + ", Weight: " + pyramid.getWeight());
            }
        }
    }
}
