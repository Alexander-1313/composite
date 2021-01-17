package com.epam.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements Component{

    private static final Logger LOGGER = LogManager.getLogger(Symbol.class);
    private final char symbol;
    private final ComponentType componentType = ComponentType.SYMBOL;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean add(Component component) {
        throw new UnsupportedOperationException("can't run method add() on class Symbol...");
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException("can't run method remove() on class Symbol...");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("can't run method size() on class Symbol...");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Can't run method getChild on class Symbol");
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Symbol{");
        sb.append("symbol=").append(symbol);
        sb.append('}');
        return sb.toString();
    }
}
