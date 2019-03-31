package com.galiglobal.dockerDsl.model;

import com.galiglobal.dockerDsl.export.DockerfilePrinter;
import com.galiglobal.dockerDsl.export.FileDockerfilePrinter;
import org.junit.Assert;
import org.junit.Test;

public class SimpleDockerfileTest {

    private static final String EXPECTED_DOCKERFILE =
            "# Comment 1\nFROM ubuntu:14.04\n# Comment 2\nRUN echo \"Hello world\" > /tmp/hello_world.txt\n";


    @Test
    public void testDockerfileJava() {
        DockerfilePrinter printer = new FileDockerfilePrinter();
        Dockerfile dockerfile = buildDockerfile();
        Assert.assertEquals(EXPECTED_DOCKERFILE, printer.print(dockerfile));
    }

    private Dockerfile buildDockerfile() {
        return Dockerfile.create(d -> {
                    d.COMMENT(" Comment 1");
                    d.FROM("ubuntu", "14.04");
                    d.COMMENT(" Comment 2");
                    d.RUN("echo \"Hello world\" > /tmp/hello_world.txt");
                }
        );
    }

}
