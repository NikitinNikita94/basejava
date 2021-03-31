package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Скайп"),
    MAIL("Электронная почта"),
    LINKEDIN("Страница Линкедин"),
    GITHUB("Страница Гитхаб"),
    STACKOVERFLOW("Страница Стековерфлоу"),
    HOME_PAGE("Домашняя страница");

    private String title;

    public String getTitle() {
        return title;
    }

    ContactType(String title) {
        this.title = title;
    }
}
