package com.guru.Ecommerce.Automation.pageobjects;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 
@Documented
//@Target(ElementType.PACKAGE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
	String authorName();
}
