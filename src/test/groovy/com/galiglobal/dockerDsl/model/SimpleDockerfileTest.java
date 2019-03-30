package com.galiglobal.dockerDsl.model;

import com.galiglobal.dockerDsl.export.DockerfilePrinter;
import com.galiglobal.dockerDsl.export.FileDockerfilePrinter;
import org.junit.Assert;
import org.junit.Test;

public class SimpleDockerfileTest {

    private static final String EXPECTED_DOCKERFILE =
            "FROM ubuntu:14.04\nRUN echo \"Hello world\" > /tmp/hello_world.txt\n";


    @Test
    public void testDockerfileJava() {
        DockerfilePrinter printer = new FileDockerfilePrinter();
        Dockerfile dockerfile = buildDockerfile();
        Assert.assertEquals(EXPECTED_DOCKERFILE, printer.print(dockerfile));
    }

    private Dockerfile buildDockerfile() {
        return Dockerfile.create(d -> {
                    d.FROM("ubuntu", "14.04");
                    d.RUN("echo \"Hello world\" > /tmp/hello_world.txt");
                }
        );
    }

}
