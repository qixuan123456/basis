package com.qx.annotation;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
}
