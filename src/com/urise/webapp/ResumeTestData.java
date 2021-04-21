package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {

    public static Resume fullResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.addContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

        SingleLineSection positionSection = new SingleLineSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям");

        SingleLineSection personalSection = new SingleLineSection("Аналитический склад ума, сильная логика, креативность, инициативность" +
                ". Пурист кода и архитектуры.");

        BulletedListSection achivementSection = new BulletedListSection(Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                        "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."));

        BulletedListSection qualificationsSection = new BulletedListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"));

        OrganizationSection workExperience = new OrganizationSection(Arrays.asList(
                new Organization("Java Online Projects", "Java Online Projects", new Organization.Period(LocalDate.of(2004, 5, 1), LocalDate.of(2004, 8, 1), "work", "work"))
        ));

        OrganizationSection educationSection = new OrganizationSection(Arrays.asList(
                new Organization("Coursera", "Coursera", new Organization.Period(LocalDate.of(2005, 04, 1), LocalDate.of(2006, 05, 1), "education", "education"))
        ));

        resume.addSection(SectionType.OBJECTIVE, positionSection);
        resume.addSection(SectionType.PERSONAL, personalSection);
        resume.addSection(SectionType.ACHIEVEMENT, achivementSection);
        resume.addSection(SectionType.QUALIFICATIONS, qualificationsSection);
        resume.addSection(SectionType.EXPERIENCE, workExperience);
        resume.addSection(SectionType.EDUCATION, educationSection);

        resume.print();

        return resume;
    }

}
