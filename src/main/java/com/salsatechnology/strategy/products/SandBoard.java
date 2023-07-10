package com.salsatechnology.strategy.products;

import com.salsatechnology.dto.ProductOrderRequest;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.strategy.CreateProductOrder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class SandBoard implements CreateProductOrder {

    private Long id;
    private String userName;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Integer timeHour;
    private Long productValue = 25L;
    private Long productTotal;
    private Long userAmount;

    @Override
    public ProductOrder calculateOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setUserName(this.userName);
        productOrder.setProductType(this.productType);
        productOrder.setTimeHour(this.timeHour);
        productOrder.setProductValue(this.productValue);
        productOrder.setProductTotal(this.timeHour * this.productValue);
        productOrder.setUserAmount(productOrder.getProductTotal() * 9);
        return productOrder;
    }
}
