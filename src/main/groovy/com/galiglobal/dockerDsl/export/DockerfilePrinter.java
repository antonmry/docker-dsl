package com.galiglobal.dockerDsl.export;

import com.galiglobal.dockerDsl.model.Dockerfile;

public interface DockerfilePrinter {
    String print(Dockerfile dockerfile);
}
