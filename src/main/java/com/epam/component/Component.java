package com.epam.component;

public interface Component {
    boolean add(Component component);

    boolean remove(Component component);

    ComponentType getComponentType();

    int size();

    Component getChild(int index);

    String toString();
}
