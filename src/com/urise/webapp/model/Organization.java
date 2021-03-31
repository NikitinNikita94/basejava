package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization extends AbstractSection {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String heading;
    private String paragraph;

    public Organization(String title, LocalDate startDate, LocalDate endDate, String heading, String paragraph) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.heading = heading;
        this.paragraph = paragraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return title.equals(that.title) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate) &&
                heading.equals(that.heading) &&
                Objects.equals(paragraph, that.paragraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startDate, endDate, heading, paragraph);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", heading='" + heading + '\'' +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
