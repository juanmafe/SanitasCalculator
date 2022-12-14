package com.sanitas.calculator.application.usecase;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sanitas.calculator.application.strategy.BasicArithmeticOperationContext;
import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.calculator.domain.usecase.CalculateBasicArithmeticOperationUseCase;

/**
 * The Class CalculateBasicArithmeticOperationUseCaseImpl.
 */
@Validated
@Service
public class CalculateBasicArithmeticOperationUseCaseImpl implements CalculateBasicArithmeticOperationUseCase {

	/** The basic arithmetic operation context. */
	@Autowired
	private BasicArithmeticOperationContext basicArithmeticOperationContext;

	@Override
	public Integer calculate(@Valid final BasicArithmeticOperationDTO operation) {

		if (ObjectUtils.anyNull(operation.getFirstNumber(), operation.getSecondNumber(),
				operation.getBasicArithmeticOperator())) {
			throw new IllegalArgumentException("Invalid parameter");
		}

		return basicArithmeticOperationContext.getResult(operation);
	}

}
