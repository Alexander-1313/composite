package com.epam.parser.impl;

import com.epam.component.Component;
import com.epam.component.ComponentType;
import com.epam.component.TextComposite;
import com.epam.parser.Parser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends BaseParser{

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String PARAGRAPH_REGEX = "\\n(\\s){4}|\\s{4}|[\\t]+";

    public ParagraphParser(Parser next) {
        super(next);
        if (next == null) {
            LOGGER.log(Level.DEBUG, "Next parser is null. It was set to SymbolParser");
            setNext(new SymbolParser());
        }
    }

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(ComponentType.TEXT);
        List<String> paragraphs = parseText(text);
        for (String paragraph : paragraphs) {
            Component nextComponent = next.parse(paragraph);
            result.add(nextComponent);
        }
        return result;
    }

    private List<String> parseText(String text) {
        String[] splitText = text.split(PARAGRAPH_REGEX);
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
