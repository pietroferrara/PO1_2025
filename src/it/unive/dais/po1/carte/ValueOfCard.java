package it.unive.dais.po1.carte;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface ValueOfCard {
    int minValue() default 1;
    int maxValue() default 10;
}
