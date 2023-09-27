package com.interview.newsreader.enuns;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LanguageNewsEnum {

    ENGLISH("en"),
    SPANISH("es"),  
    FRENCH("fr"),
    ITALIAN("it"),
    PORTUGUESE("pt");

    public String abbreviation;

    LanguageNewsEnum(String s) {
        abbreviation = s;
    }

    @JsonValue
    public String getAbbreviation() {
        return abbreviation;
    }
}
