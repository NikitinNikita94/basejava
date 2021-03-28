package com.urise.webapp.model;

import java.util.Objects;

public class Experience {
    private String depictLineExperience;

    public Experience(String depictLineExperience) {
        this.depictLineExperience = depictLineExperience;
    }

    public String getDepictLineExperience() {
        return depictLineExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return depictLineExperience.equals(that.depictLineExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depictLineExperience);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "depictLineExperience='" + depictLineExperience + '\'' +
                '}';
    }
}
