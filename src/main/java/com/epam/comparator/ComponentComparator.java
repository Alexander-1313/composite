package com.epam.comparator;

import com.epam.component.Component;

import java.util.Comparator;

public enum ComponentComparator implements Comparator<Component> {

    SENTENCE_NUMBER{
        @Override
        public int compare(Component o1, Component o2) {
            int size1 = o1.size();
            int size2 = o2.size();

            return Integer.compare(size1, size2);
        }
    }
}
