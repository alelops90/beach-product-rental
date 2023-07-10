package com.salsatechnology.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.salsatechnology.model.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductOrderRequest {
	
	@NotBlank
	private String userName;
	
	@NotNull
	private ProductType productType;
	
	@NotNull
	private Integer timeHour;
}
