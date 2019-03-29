package domain;

import java.util.Objects;
import java.util.function.Consumer;

public class Dockerfile {

    public static Dockerfile create(Consumer<Dockerfile> diagramConsumer) {
        Dockerfile diagram = new Dockerfile();
        diagramConsumer.accept(diagram);
        return diagram;
    }

    private From fromKeyword;
    private Run runKeyword;

    public From FROM(String origin, String version) {
        From f = new From(origin, version);
        this.fromKeyword = f;
        return f;
    }

    public Run RUN(String command) {
        Run r = new Run(command);
        this.runKeyword = r;
        return r;
    }

    // Getters, setters, etc.

    public From getFromKeyword() {
        return fromKeyword;
    }

    public void setFromKeyword(From fromKeyword) {
        this.fromKeyword = fromKeyword;
    }

    public Run getRunKeyword() {
        return runKeyword;
    }

    public void setRunKeyword(Run runKeyword) {
        this.runKeyword = runKeyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dockerfile that = (Dockerfile) o;
        return Objects.equals(fromKeyword, that.fromKeyword) &&
                Objects.equals(runKeyword, that.runKeyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromKeyword, runKeyword);
    }

    @Override
    public String toString() {
        return "Dockerfile{" +
                "fromKeyword=" + fromKeyword +
                ", runKeyword=" + runKeyword +
                '}';
    }
}
