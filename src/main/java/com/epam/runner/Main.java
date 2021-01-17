package com.epam.runner;

import com.epam.comparator.ComponentComparator;
import com.epam.component.Component;
import com.epam.exception.ReaderException;
import com.epam.parser.Parser;
import com.epam.parser.ParserChain;
import com.epam.reader.DataReader;
import com.epam.service.TextCompositeService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws ReaderException, URISyntaxException, IOException {
        DataReader reader = new DataReader();

        String text = reader.readFile("/home/alexander/text.txt");
        System.out.println(text);

        Parser parser = ParserChain.getInstance();
        Component component = parser.parse(text);
        System.out.println(component);

        TextCompositeService service = new TextCompositeService();

//        Component word = service.findSentenceWithMaxLenWord(component);
//        System.out.println(word);
//        service.deleteSentencesWithWordCountLessThen(component, 10);
//        System.out.println(component);

        service.sort(component, ComponentComparator.SENTENCE_NUMBER);
        System.out.println(component);
    }
}
