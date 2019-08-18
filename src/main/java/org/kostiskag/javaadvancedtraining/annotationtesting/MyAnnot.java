package org.kostiskag.javaadvancedtraining.annotationtesting;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
public @interface MyAnnot {
    Animal value() default Animal.CAT;
    int num() default 1;
}
