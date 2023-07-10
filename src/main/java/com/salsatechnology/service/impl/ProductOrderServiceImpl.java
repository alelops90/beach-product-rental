package com.salsatechnology.service.impl;

import javax.transaction.Transactional;

import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.mapper.ProductOrderMapper;
import com.salsatechnology.service.ProductOrderService;
import com.salsatechnology.strategy.CalculateOrder;
import com.salsatechnology.strategy.products.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.salsatechnology.dto.ProductOrderRequest;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.ProductOrderRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Autowired
    private CalculateOrder calculateOrder;

    @Transactional
    public ProductOrderResponse createOrder(ProductOrderRequest productOrderRequest) {

        ProductOrder productOrder = productCalculated(productOrderRequest);
        productOrderRepository.save(productOrder);
        return productOrderMapper.toResponse(productOrder);
    }

    @Override
    public Page<ProductOrderResponse> findByProduct(String product) {
        List<ProductOrder> filterOrder = productOrderRepository.findByProductType(product);
        return new PageImpl<>(converteToResponse(filterOrder));
    }

    private List<ProductOrderResponse> converteToResponse(List<ProductOrder> filterOrder) {
        return filterOrder.stream()
                .map(order -> productOrderMapper.toResponse(order))
                .collect(Collectors.toList());
    }

    private ProductOrder productCalculated(ProductOrderRequest productOrderRequest) {
        switch (productOrderRequest.getProductType()) {
            case SUNSHADE:
                Sunshade sunshade = productOrderMapper.toSunshade(productOrderRequest);
                return calculateOrder.createOrder(sunshade);
            case SAND_BOARD:
                SandBoard sandBoard = productOrderMapper.toSandBoard(productOrderRequest);
                return calculateOrder.createOrder(sandBoard);
            case SURFBOARD:
                SurfBoard surfBoard = productOrderMapper.toSurfBoard(productOrderRequest);
                return calculateOrder.createOrder(surfBoard);
            case BEACH_CHAIR:
                BeachChair beachChair = productOrderMapper.toBeachChair(productOrderRequest);
                return calculateOrder.createOrder(beachChair);
            case BEACH_TABLE:
                BeachTable beachTable = productOrderMapper.toBeachTable(productOrderRequest);
                return calculateOrder.createOrder(beachTable);
            default:
                throw new RuntimeException("This product don´t exists");
        }
    }
}
