package com.epam.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component{

    private static final Logger LOGGER = LogManager.getLogger(TextComposite.class);
    private final List<Component> components;
    private final ComponentType componentType;

    public TextComposite(ComponentType componentType) {
        components = new ArrayList<>();
        this.componentType = componentType;
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TextComposite{");
        sb.append("components=").append(components);
        sb.append(", componentType=").append(componentType);
        sb.append('}');
        return sb.toString();
    }
}
