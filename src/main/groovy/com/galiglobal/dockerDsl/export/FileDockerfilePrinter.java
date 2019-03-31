package com.galiglobal.dockerDsl.export;

import com.galiglobal.dockerDsl.model.*;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FileDockerfilePrinter implements DockerfilePrinter {

    @Override
    public String print(Dockerfile dockerfile) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        for (Line line : dockerfile.getLines()) {

            // TODO: find a way to avoid type inspection
            TypeOfLine t = TypeOfLine.valueOf(line.getClass().getSimpleName());
            switch (t) {
                case From:
                    printWriter.println(print((From) line));
                    break;
                case Run:
                    printWriter.println(print((Run) line));
                    break;
                case Comment:
                    printWriter.println(print((Comment) line));
                    break;
            }
        }

        return stringWriter.toString();
    }

    private String print(From f) {
        return String.format("FROM %s:%s", f.getOrigin(), f.getVersion());
    }

    private String print(Run r) {
        return String.format("RUN %s", r.getCommand());
    }

    private String print(Comment c) {
        return String.format("#%s", c.getText());
    }
}

enum TypeOfLine{
    From, Run, Comment;
}

