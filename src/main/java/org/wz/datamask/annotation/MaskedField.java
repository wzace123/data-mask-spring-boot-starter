package org.wz.datamask.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Data Mask Field
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MaskedField {

    /**
     * Field Type
     */
    String value();

    /**
     * Custom Id
     * @return
     */
    String id() default "";

}
