package com.urise.webapp.storage;

import com.urise.webapp.model.*;

public class ResumeDataTest {

    public static void main(String[] args) {
        Resume resume = new Resume("Name Surname");
        System.out.println(resume.toString());
        resume.contacts.put(ContactType.PHONE_NUMBER, "544-444-4444");
        AbstractSection sec = new TextSection("FRIENDLY AS HELL");
        resume.section.put(SectionType.PERSONAL, sec);
        System.out.println(resume.contacts.values());
        System.out.println(resume.getSectionContent(SectionType.PERSONAL).);
    }
}
