package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String heading;
    private final String paragraph;

    public Period(LocalDate startDate, LocalDate endDate, String heading, String paragraph) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(heading, "heading must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.heading = heading;
        this.paragraph = paragraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period periods = (Period) o;
        return startDate.equals(periods.startDate) &&
                endDate.equals(periods.endDate) &&
                heading.equals(periods.heading) &&
                Objects.equals(paragraph, periods.paragraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, heading, paragraph);
    }

    @Override
    public String toString() {
        return "Periods{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", heading='" + heading + '\'' +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
