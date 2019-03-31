package com.galiglobal.dockerDsl.model;

public interface DockerfileDefinition {

    From FROM(String origin);

    From FROM(String origin, String version);

    Run RUN(String command);

    Comment COMMENT(String text);
}
