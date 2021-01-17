package com.epam.parser.impl;

import com.epam.component.Component;
import com.epam.component.ComponentType;
import com.epam.component.TextComposite;
import com.epam.parser.Parser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordParser extends BaseParser{

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String WORD_REGEX = "\\p{Punct}|\\p{Alpha}+|\"";

    public WordParser(Parser next) {
        super(next);
        if (next == null) {
            LOGGER.log(Level.DEBUG, "Next parser is null. It was set to SymbolParser");
            setNext(new SymbolParser());
        }
    }

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(ComponentType.LEXEME);
        List<String> words = parseText(text);
        for (String word : words) {
            Component nextComponent = next.parse(word);
            result.add(nextComponent);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            result.add(matcher.group());
        }
        return result;
//        String[] splitText = text.split(WORD_REGEX);
//        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
//        return result;
    }

}
