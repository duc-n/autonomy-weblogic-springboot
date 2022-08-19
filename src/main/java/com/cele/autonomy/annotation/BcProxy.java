package com.cele.autonomy.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;



/**
 * Defined a field as being a proxy to be instantiated by framework.<br>
 * 
 * @author mikael_taraboletti
 * 
 */
@Retention( RUNTIME )
@Target( FIELD )
@Documented
public @interface BcProxy {
	/**
	 * If true, all proxy method call will be in anonymous mode.
	 * 
	 * @return
	 */
	boolean anonymous() default false;
	
	String location() default "";
}