package com.galiglobal.dockerDsl.model

import com.galiglobal.dockerDsl.export.DockerfilePrinter
import com.galiglobal.dockerDsl.export.FileDockerfilePrinter
import groovy.transform.CompileStatic
import spock.lang.Specification
import spock.lang.Unroll

class SimpleDockerfileSpec extends Specification {

    private static final String EXPECTED_DOCKERFILE = '''
        # Comment 1
        FROM ubuntu:14.04
        # Comment 2
        RUN echo "Hello world" > /tmp/hello_world.txt
    '''.stripIndent().trim()

    @Unroll
    def "basic Dockerfile"() {

        given:
        DockerfilePrinter printer = new FileDockerfilePrinter()
        expect:
        printer.print(dockerfile).trim() == expected

        where:
        title              | dockerfile        | expected
        'basic dockerfile' | buildDockerfile() | EXPECTED_DOCKERFILE
    }

    @CompileStatic
    private static Dockerfile buildDockerfile() {
        Dockerfile.build { DockerfileDefinition d ->
            COMMENT(' Comment 1')
            FROM('ubuntu', '14.04')
            COMMENT(' Comment 2')
            RUN('echo "Hello world" > /tmp/hello_world.txt')
        }
    }
}
