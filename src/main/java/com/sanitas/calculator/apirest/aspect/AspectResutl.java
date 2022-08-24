package com.sanitas.calculator.apirest.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.corp.calculator.TracerImpl;

/**
 * The Class AspectResutl.
 */
@Aspect
@Component
public class AspectResutl {

	/**
	 * Prints the result.
	 *
	 * @param result the result
	 */
	@AfterReturning(pointcut = "execution(* com.sanitas.calculator.apirest.controller.BasicArithmeticOperationController.basicArithmeticOperationV1(..))", returning = "result")
	public void printResult(Object result) {

		ResponseEntity<Integer> responseEntity = (ResponseEntity) result;
		TracerImpl tracer = new TracerImpl();
		tracer.trace(responseEntity.getBody());
	}
}
