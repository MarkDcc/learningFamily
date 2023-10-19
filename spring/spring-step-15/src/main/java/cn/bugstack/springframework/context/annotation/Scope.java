package cn.bugstack.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @Author:dongchen
 * @Date: 2023/5/28 16:38
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
	String value() default "singleton";
}
