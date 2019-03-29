package com.galiglobal.dockerDsl.model.groovy;

import com.galiglobal.dockerDsl.model.model.Dockerfile;
import com.galiglobal.dockerDsl.model.model.DockerfileContent;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import space.jasan.support.groovy.closure.ConsumerWithDelegate;

public class DockerfileStaticExtensions {

    public static Dockerfile build(
            Dockerfile self,
            @DelegatesTo(value = Dockerfile.class, strategy = Closure.DELEGATE_FIRST)
            @ClosureParams(value = SimpleType.class, options = "Dockerfile")
                    Closure<? extends DockerfileContent> dockerfile
    ) {
        return Dockerfile.create(ConsumerWithDelegate.create(dockerfile));
    }

}
