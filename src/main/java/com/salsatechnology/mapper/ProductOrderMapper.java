package com.salsatechnology.mapper;

import com.salsatechnology.dto.ProductOrderRequest;
import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.strategy.products.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductOrderMapper {

    BeachChair toBeachChair(ProductOrderRequest productOrderRequest);

    BeachTable toBeachTable(ProductOrderRequest productOrderRequest);

    SandBoard toSandBoard(ProductOrderRequest productOrderRequest);

    Sunshade toSunshade(ProductOrderRequest productOrderRequest);

    SurfBoard toSurfBoard(ProductOrderRequest productOrderRequest);

    ProductOrderResponse toResponse(ProductOrder productOrder);


}
