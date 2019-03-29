package export;

import domain.Dockerfile;
import domain.From;
import domain.Run;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DockerfilePrinter {

    public String print(Dockerfile dockerfile) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.println(print(dockerfile.getFrom()));
        printWriter.println(print(dockerfile.getRun()));

        return stringWriter.toString();
    }

    private String print(From f) {
        return String.format("FROM %s:%s", f.getOrigin(), f.getVersion());
    }

    private String print(Run r) {
        return String.format("RUN %s", r.getCommand());
    }
}
