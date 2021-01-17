package com.epam.parser;

import com.epam.component.Component;
import com.epam.parser.impl.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParserChain implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(ParserChain.class);
    private static Parser instance;
    private final Parser symbolParser = new SymbolParser();
    private final Parser wordParser = new WordParser(symbolParser);
    private final Parser lexemeParser = new LexemeParser(wordParser);
    private final Parser sentenceParser = new SentenceParser(lexemeParser);
    private final Parser paragraphParser = new ParagraphParser(sentenceParser);

    private ParserChain() {
    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new ParserChain();
            LOGGER.log(Level.INFO, "Parser chain is created");
        }
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component result = paragraphParser.parse(text);
        LOGGER.log(Level.INFO, "Text parsing is complete");
        return result;
    }
}
