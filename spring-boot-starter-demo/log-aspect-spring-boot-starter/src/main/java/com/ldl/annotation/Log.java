package com.ldl.annotation;


import com.ldl.bean.OperType;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String title() default "";

    OperType type() default OperType.OTGER;

}
