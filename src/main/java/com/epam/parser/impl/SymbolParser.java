package com.epam.parser.impl;

import com.epam.component.Component;
import com.epam.component.ComponentType;
import com.epam.component.Symbol;
import com.epam.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolParser extends BaseParser {

    private static final Logger LOGGER = LogManager.getLogger(SymbolParser.class);
    private static final String SYMBOL_REGEX = "";

    public SymbolParser() {
        super(null);
    }

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(ComponentType.WORD);
        List<String> symbols = parseText(text);
        for (String symbol : symbols) {
            Symbol leaf = new Symbol(symbol.charAt(0));
            result.add(leaf);
        }
        return result;
    }

    private List<String> parseText(String text) {
        String[] splitText = text.split(SYMBOL_REGEX);
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}