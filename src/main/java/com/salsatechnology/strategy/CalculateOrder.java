package com.salsatechnology.strategy;

import com.salsatechnology.model.ProductOrder;
import org.springframework.stereotype.Service;

@Service
public class CalculateOrder {

    public ProductOrder createOrder(CreateProductOrder createProductOrder){
        return createProductOrder.calculateOrder();
    }

}
