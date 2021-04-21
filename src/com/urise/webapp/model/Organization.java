package com.urise.webapp.model;

import com.urise.webapp.util.DateUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.urise.webapp.util.DateUtil.NOW;
import static com.urise.webapp.util.DateUtil.of;

public class Organization implements Serializable {
    private final static long serialVersionUID = 1L;

    private final Link homePage;
    private List<Period> period = new ArrayList<>();

    public Organization(String name, String url, Period... periods) {
        this(new Link(name, url), Arrays.asList(periods));
    }

    public Organization(Link homePage, List<Period> period) {
        this.homePage = homePage;
        this.period = period;
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

    public static class Period implements Serializable {

        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String heading;
        private final String paragraph;

        public Period(int startYear, Month startMonth, String title, String description) {
            this(DateUtil.of(startYear, startMonth), NOW, title, description);
        }

        public Period(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Period(LocalDate startDate, LocalDate endDate, String heading, String paragraph) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(heading, "heading must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.heading = heading;
            this.paragraph = paragraph;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getHeading() {
            return heading;
        }

        public String getParagraph() {
            return paragraph;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Period period = (Period) o;
            return startDate.equals(period.startDate) &&
                    endDate.equals(period.endDate) &&
                    heading.equals(period.heading) &&
                    Objects.equals(paragraph, period.paragraph);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, heading, paragraph);
        }

        @Override
        public String toString() {
            return "Period{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", heading='" + heading + '\'' +
                    ", paragraph='" + paragraph + '\'' +
                    '}';
        }
    }

}
