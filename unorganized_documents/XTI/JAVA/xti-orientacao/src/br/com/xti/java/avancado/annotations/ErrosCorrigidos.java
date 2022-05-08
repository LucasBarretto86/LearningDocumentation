package br.com.xti.java.avancado.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ErrosCorrigidos {

	String[] erros();

}
