package com.interview.newsreader.enuns;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortNewsEnum {

    RELEVANCY("relevancy"),
    POPULARITY("popularity"),  
    PUBLISHEDAT("publishedAt");

    public String value;

    SortNewsEnum(String v) {
        value = v;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
