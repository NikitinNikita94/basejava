package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class BulletedListSection extends Section {
    private List<String> listSection;

    public BulletedListSection(List<String> list) {
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
