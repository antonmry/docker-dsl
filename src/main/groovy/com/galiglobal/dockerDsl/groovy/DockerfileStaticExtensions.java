package com.galiglobal.dockerDsl.groovy;

import com.galiglobal.dockerDsl.model.Dockerfile;
import com.galiglobal.dockerDsl.model.DockerfileDefinition;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import space.jasan.support.groovy.closure.ConsumerWithDelegate;

public class DockerfileStaticExtensions {

    public static Dockerfile build(
            Dockerfile self,
            @DelegatesTo(value = DockerfileDefinition.class, strategy = Closure.DELEGATE_FIRST)
            @ClosureParams(value = SimpleType.class, options = "com.galiglobal.dockerDsl.model.DockerfileDefinition")
                    Closure definition
    ) {
        return self.create(ConsumerWithDelegate.create(definition));
    }

}
