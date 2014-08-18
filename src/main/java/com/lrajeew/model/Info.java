package com.lrajeew.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Info {

	public String description() default "";
	public String url() default ""; 
	public String testCase() default "";
	public String method() default "GET";
}
