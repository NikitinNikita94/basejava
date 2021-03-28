package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Скайп"),
    EMAIL("Электронная почта"),
    LINKEDIN("Страница Линкедин"),
    GITHUB("Страница Гитхаб"),
    STACKOVERFLOW("Страница Стековерфлоу"),
    HOMEPAGE("Домашняя страница");

    private String title;

    public String getTitle() {
        return title;
    }

    ContactType(String title) {
        this.title = title;
    }
}
