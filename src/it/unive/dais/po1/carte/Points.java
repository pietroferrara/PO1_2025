package it.unive.dais.po1.carte;

import java.lang.annotation.Retention;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Points {
    String type() default "3 punti per vittoria";
}
