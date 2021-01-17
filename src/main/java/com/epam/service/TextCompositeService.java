package com.epam.service;

import com.epam.component.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextCompositeService {

    private static final Logger LOGGER = LogManager.getLogger(TextCompositeService.class);

    public Component findSentenceWithMaxLenWord(Component component) {
        int max = 0;
        Component result = null;

        for (int i = 0; i < component.size(); i++) {
            Component paragraph = component.getChild(i);

            for (int j = 0; j < paragraph.size(); j++) {
                Component sentence = paragraph.getChild(j);

                for (int k = 0; k < sentence.size(); k++) {
                    Component word = sentence.getChild(k);
                    if (word.size() > max) {
                        max = word.size();
                        result = sentence;
                    }
                }
            }
        }
        return result;
    }

    public void deleteSentencesWithWordCountLessThen(Component component, int countOfWords) {
        for (int i = 0; i < component.size(); i++) {
            Component paragraph = component.getChild(i);

            for (int j = 0; j < paragraph.size(); j++) {
                Component sentence = paragraph.getChild(j);
                System.out.println(sentence.size());
                if (sentence.size() < countOfWords) {
                    paragraph.remove(sentence);
                }
            }

        }
    }

    public List<Component> sort(Component component, Comparator<Component> comparator) {
        List<Component> result = new ArrayList<>();

        for (int i = 0; i < component.size(); i++) {
            Component child = component.getChild(i);
            result.add(child);
            System.out.println(child.size());
        }

        result.sort(comparator);
        LOGGER.log(Level.INFO, "Sorting complete");

        return result;
    }
}
