package com.urise.webapp.model;

public enum ContactType {

    PHONE_NUMBER("Phone number"),
    SKYPE("Skype"),
    EMAIL("Email"),
    LINKEDIN("Linkerdin"),
    GITHUB("Github"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("Home Page");

    private final String contact;

    ContactType(String contact) {
        this.contact = contact;
    }
}
