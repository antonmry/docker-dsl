package export;

import domain.Dockerfile;

public class DockerfilePrinter {

    public String print(Dockerfile dockerfile) {
        return dockerfile.toString();
    }
}
