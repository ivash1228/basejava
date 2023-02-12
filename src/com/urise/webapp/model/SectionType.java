package com.urise.webapp.model;

public enum SectionType {

    PERSONAL(""),
    OBJECTIVE(""),
    ACHIEVEMENT(""),
    QUALIFICATION(""),
    EXPERIENCE(""),
    EDUCATION("");

    public final String sectionContent;

    SectionType(String sectionContent) {
        this.sectionContent = sectionContent;
    }
}
