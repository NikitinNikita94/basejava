package com.urise.webapp.model;

import java.util.Objects;

public class Organization extends Section {
    LocalDate date;
    Experience experience;

    public Organization(LocalDate date, Experience experience) {
        this.date = date;
        this.experience = experience;
    }

    public LocalDate getDate() {
        return date;
    }

    public Experience getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return date.equals(that.date) &&
                experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, experience);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "date=" + date +
                ", experience=" + experience +
                '}';
    }
}
