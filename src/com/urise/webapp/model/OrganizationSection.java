package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private final static long serialVersionUID = 1L;

    private List<Organization> listOrganization;

    public OrganizationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(List<Organization> listOrganization) {
        Objects.requireNonNull(listOrganization, "listOrganization must not be null");
        this.listOrganization = listOrganization;
    }

    public List<Organization> getListOrganization() {
        return listOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return listOrganization.equals(that.listOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOrganization);
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "listOrganization=" + listOrganization +
                '}';
    }
}
