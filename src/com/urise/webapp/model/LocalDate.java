package com.urise.webapp.model;

import java.util.Objects;

public class LocalDate {
    private String date;

    public LocalDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalDate localDate = (LocalDate) o;
        return date.equals(localDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "LocalDate{" +
                "date='" + date + '\'' +
                '}';
    }
}
