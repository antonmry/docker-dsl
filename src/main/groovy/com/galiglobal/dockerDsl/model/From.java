package com.galiglobal.dockerDsl.model;

import java.util.Objects;

public class From extends Line {

    private String origin;
    private String version;

    public From(String origin, String version) {
        this.origin = origin;
        this.version = version;
    }

    public From(String origin) {
        this.origin = origin;
        this.version = "latest";
    }

    public String getOrigin() {
        return origin;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        From from = (From) o;
        return origin.equals(from.origin) &&
                version.equals(from.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, version);
    }

    @Override
    public String toString() {
        return "From{" +
                "origin='" + origin + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
