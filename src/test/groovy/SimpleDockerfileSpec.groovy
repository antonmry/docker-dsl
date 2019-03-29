import domain.Dockerfile
import export.DockerfilePrinter
import groovy.transform.CompileStatic
import spock.lang.Specification
import spock.lang.Unroll

class SimpleDockerfileSpec extends Specification {

    private static final String EXPECTED_DOCKERFILE = '''
        FROM ubuntu:14.04
        RUN echo "Hello world" > /tmp/hello_world.txt
    '''.stripIndent().trim()

    @Unroll
    def "basic Dockerfile"() {

        given:
        DockerfilePrinter printer = new DockerfilePrinter()
        expect:
        printer.print(dockerfile).trim() == expected

        where:
        title              | dockerfile        | expected
        'basic dockerfile' | buildDockerfile() | EXPECTED_DOCKERFILE
    }

    @CompileStatic
    private static Dockerfile buildDockerfile() {
        Dockerfile.create { Dockerfile d ->
            d.FROM('ubuntu', '14.04')
            d.RUN('echo "Hello world" > /tmp/hello_world.txt')
        }
    }
}
