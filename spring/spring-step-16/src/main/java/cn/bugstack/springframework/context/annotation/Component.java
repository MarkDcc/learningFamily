package cn.bugstack.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @Author:dongchen
 * @Date: 2023/5/28 16:37
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a Spring bean in case of an autodetected component.
	 * @return the suggested component name, if any (or empty String otherwise)
	 */
	String value() default "";

}
