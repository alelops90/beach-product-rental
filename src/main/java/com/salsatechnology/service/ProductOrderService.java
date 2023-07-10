package com.salsatechnology.service;

import com.salsatechnology.dto.ProductOrderRequest;
import com.salsatechnology.dto.ProductOrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductOrderService {

    ProductOrderResponse createOrder(ProductOrderRequest productOrderDTO);

    Page<ProductOrderResponse> findByProduct(String product);

}
