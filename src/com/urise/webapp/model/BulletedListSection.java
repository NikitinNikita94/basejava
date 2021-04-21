package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BulletedListSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private final List<String> listSection;

    public BulletedListSection(String... listSection) {
    this(Arrays.asList(listSection));
    }

    public BulletedListSection(List<String> list) {
        Objects.requireNonNull(list, "list must not be null");
        this.listSection = list;
    }

    public List<String> getList() {
        return listSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BulletedListSection that = (BulletedListSection) o;
        return listSection.equals(that.listSection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listSection);
    }

    @Override
    public String toString() {
        return "BulletedListSection{" +
                "list=" + listSection +
                '}';
    }
}
