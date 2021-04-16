package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.*;

public class Organization extends AbstractSection {
    private final Link homePage;
    private final List<Period> period;

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String heading, String paragraph) {
        this.homePage = new Link(name, url);
        this.period = new ArrayList<Period>(Collections.singleton(new Period(startDate, endDate, heading, paragraph)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, period);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", period=" + period +
                '}';
    }
}
