package com.galiglobal.dockerDsl.model;

import java.util.Objects;
import java.util.function.Consumer;

public class Dockerfile implements DockerfileDefinition {

    public static Dockerfile create(Consumer<DockerfileDefinition> dockerfileConsumer) {
        Dockerfile dockerfile = new Dockerfile();
        dockerfileConsumer.accept(dockerfile);
        return dockerfile;
    }

    private From from;
    private Run run;

    @Override
    public From FROM(String origin, String version) {
        From f = new From(origin, version);
        this.from = f;
        return f;
    }

    @Override
    public From FROM(String origin) {
        From f = new From(origin);
        this.from = f;
        return f;
    }

    @Override
    public Run RUN(String command) {
        Run r = new Run(command);
        this.run = r;
        return r;
    }

    // Getters, setters, etc.

    public From getFrom() {
        return from;
    }

    public Run getRun() {
        return run;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dockerfile that = (Dockerfile) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(run, that.run);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, run);
    }

    @Override
    public String toString() {
        return "Dockerfile{" +
                "from=" + from +
                ", run=" + run +
                '}';
    }
}
