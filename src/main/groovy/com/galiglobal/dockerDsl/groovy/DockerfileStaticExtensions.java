package com.galiglobal.dockerDsl.groovy;

import com.galiglobal.dockerDsl.model.DockerfileContent;
import com.galiglobal.dockerDsl.model.Dockerfile;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import space.jasan.support.groovy.closure.ConsumerWithDelegate;

public class DockerfileStaticExtensions {

    public static Dockerfile build(
            Dockerfile self,
            @DelegatesTo(value = Dockerfile.class, strategy = Closure.DELEGATE_FIRST)
            @ClosureParams(value = SimpleType.class, options = "com.galiglobal.dockerDsl.model.Dockerfile")
                    Closure definition
    ) {
        return self.create(ConsumerWithDelegate.create(definition));
    }

}
