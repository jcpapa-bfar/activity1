package com.fimc.calculator.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CalculatorResponse implements Serializable {
	private String action;
	private double result;
}
