package org.example.Q1;
import java.util.ArrayList;
import java.util.List;

public class ContainerManager {
    private List<IMeasurableContainer> containers;

    public ContainerManager() {
        containers = new ArrayList<>();
    }

    public void add(IMeasurableContainer container) {
        containers.add(container);
    }

    public double totalWeight() {
        return containers.stream().mapToDouble(IMeasurableContainer::weight).sum();
    }

    public double totalRectangularVolume() {
        return containers.stream().mapToDouble(IMeasurableContainer::rectangularVolume).sum();
    }

    public void clearAll() {
        containers.clear();
    }

    public List<IMeasurableContainer> getAllContainers() {
        return new ArrayList<>(containers);
    }
}


