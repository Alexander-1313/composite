package com.epam.parser.impl;

import com.epam.parser.Parser;

public abstract class BaseParser implements Parser {

    protected Parser next;

    public BaseParser(Parser next) {
        this.next = next;
    }

    public void setNext(Parser next) {
        this.next = next;
    }
}
