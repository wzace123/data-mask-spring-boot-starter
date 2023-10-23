package org.wz.datamask.annotation;

import org.wz.datamask.enums.MaskedType;

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
     * 字段类型
     */
    MaskedType value();

    /**
     * 自定义id
     * @return
     */
    String id() default "";

}
