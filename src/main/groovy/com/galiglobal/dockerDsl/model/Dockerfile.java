package com.galiglobal.dockerDsl.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Consumer;

public class Dockerfile implements DockerfileDefinition {

    public static Dockerfile create(Consumer<DockerfileDefinition> dockerfileConsumer) {
        Dockerfile dockerfile = new Dockerfile();
        dockerfileConsumer.accept(dockerfile);
        return dockerfile;
    }

    private Collection<Line> lines = new ArrayList<>();

    @Override
    public From FROM(String origin, String version) {
        From f = new From(origin, version);
        lines.add(f);
        return f;
    }

    @Override
    public From FROM(String origin) {
        From f = new From(origin);
        lines.add(f);
        return f;
    }

    @Override
    public Run RUN(String command) {
        Run r = new Run(command);
        lines.add(r);
        return r;
    }

    @Override
    public Comment COMMENT(String text) {
        Comment c = new Comment(text);
        lines.add(c);
        return c;
    }

    // Getters, setters, etc.

    public Collection<Line> getLines() {
        return Collections.unmodifiableCollection(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dockerfile that = (Dockerfile) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Dockerfile{" +
                "lines=" + lines +
                '}';
    }
}
