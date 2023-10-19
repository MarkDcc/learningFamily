package cn.bugstack.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author:dongchen
 * @Date: 2023/9/3 13:34
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
