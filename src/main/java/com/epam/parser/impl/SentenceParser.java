package com.epam.parser.impl;

import com.epam.component.Component;
import com.epam.component.ComponentType;
import com.epam.component.TextComposite;
import com.epam.parser.Parser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String SENTENCE_REGEX = "([.?!…]\\s)+|([.?!…]\t)+|([.?!…]\\s{4})+|([.?!…]\\n)+|([.?!…]\\n\\s{4})+";

    public SentenceParser(Parser next) {
        super(next);
        if (next == null) {
            LOGGER.log(Level.DEBUG, "Next parser is null. It was set to SymbolParser");
            setNext(new SymbolParser());
        }
    }

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(ComponentType.PARAGRAPH);
        List<String> sentences = parseText(text);
        for (String sentence : sentences) {
            Component nextComponent = next.parse(sentence);
            result.add(nextComponent);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        int index = 0;
        String buffer;
        while (matcher.find(index)) {
            buffer = text.substring(index, matcher.start() + 1);
            result.add(buffer);
            index = matcher.end();
        }
        buffer = text.substring(index);
        result.add(buffer);
        return result;
    }
}