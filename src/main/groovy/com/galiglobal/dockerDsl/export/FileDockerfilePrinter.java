package com.galiglobal.dockerDsl.export;

import com.galiglobal.dockerDsl.model.From;
import com.galiglobal.dockerDsl.model.Run;
import com.galiglobal.dockerDsl.model.Dockerfile;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FileDockerfilePrinter implements DockerfilePrinter {

    @Override
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
