package domain;

import java.util.Objects;
import java.util.function.Consumer;

public class Dockerfile {

    public static Dockerfile create(Consumer<Dockerfile> diagramConsumer) {
        Dockerfile diagram = new Dockerfile();
        diagramConsumer.accept(diagram);
        return diagram;
    }

    private From from;
    private Run run;

    public From FROM(String origin, String version) {
        From f = new From(origin, version);
        this.from = f;
        return f;
    }

    public Run RUN(String command) {
        Run r = new Run(command);
        this.run = r;
        return r;
    }

    // Getters, setters, etc.

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
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
