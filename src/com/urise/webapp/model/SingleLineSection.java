package com.urise.webapp.model;

import java.util.Objects;

public class SingleLineSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private final String lineSection;

    public SingleLineSection(String lineSection) {
        Objects.requireNonNull(lineSection, "lineSection must not be null");
        this.lineSection = lineSection;
    }

    public String getLineSection() {
        return lineSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLineSection that = (SingleLineSection) o;
        return lineSection.equals(that.lineSection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineSection);
    }

    @Override
    public String toString() {
        return "SingleLineSection{" +
                "lineSection='" + lineSection + '\'' +
                '}';
    }
}
