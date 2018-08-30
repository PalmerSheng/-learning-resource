package com.sf.common;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截Service
 * @author YangTao
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD}) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented 
public @interface SystemServiceLog {
	 String value() default "";
}
