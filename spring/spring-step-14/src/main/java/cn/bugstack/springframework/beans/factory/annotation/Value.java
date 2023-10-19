package cn.bugstack.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author:dongchen
 * @Date: 2023/9/3 13:34
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
