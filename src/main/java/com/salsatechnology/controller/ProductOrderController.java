package com.salsatechnology.controller;

import javax.validation.Valid;

import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salsatechnology.dto.ProductOrderRequest;

@RestController
@RequestMapping("/orders")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductOrderResponse> createOrder(@RequestBody @Valid ProductOrderRequest productOrderDTO) {
		ProductOrderResponse response = productOrderService.createOrder(productOrderDTO);
		return ResponseEntity.ok(response);
	}

	@GetMapping("findBy/{product}")
	public ResponseEntity<Page<ProductOrderResponse>> findByProduct(@PathVariable String product){
		Page<ProductOrderResponse> pageOrder = productOrderService.findByProduct(product);
		return ResponseEntity.ok(pageOrder);
	}
}
