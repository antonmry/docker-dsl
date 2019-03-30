package com.galiglobal.dockerDsl.model;

import java.util.Objects;

public class Run {

    private String command;

    public Run(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return command.equals(run.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public String toString() {
        return "Run{" +
                "command='" + command + '\'' +
                '}';
    }
}
