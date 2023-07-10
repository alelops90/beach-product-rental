package com.salsatechnology.mockForTest;

import com.salsatechnology.dto.ProductOrderRequest;
import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class MockForTest {

    public static ProductOrderRequest createProductOrderRequestSurf(){
        return ProductOrderRequest.builder()
                .userName("John")
                .productType(ProductType.SURFBOARD)
                .timeHour(3)
                .build();
    }

    public static ProductOrderResponse createdProductOrderResponseSurf(){
        return ProductOrderResponse.builder()
                .id(3L)
                .userName("John")
                .productType(ProductType.SURFBOARD)
                .timeHour(3)
                .productValue(50L)
                .productTotal(150L)
                .userAmount(2340L)
                .build();
    }

    public static ProductOrderRequest createProductOrderRequestBeachChair(){
        return ProductOrderRequest.builder()
                .userName("John")
                .productType(ProductType.BEACH_CHAIR)
                .timeHour(3)
                .build();
    }

    public static ProductOrderResponse createdProductOrderResponseBeachChair(){
        return ProductOrderResponse.builder()
                .id(3L)
                .userName("John")
                .productType(ProductType.BEACH_CHAIR)
                .timeHour(3)
                .productValue(35L)
                .productTotal(105L)
                .userAmount(525L)
                .build();
    }

    public static ProductOrderRequest createProductOrderRequestSunshade(){
        return ProductOrderRequest.builder()
                .userName("John")
                .productType(ProductType.SUNSHADE)
                .timeHour(3)
                .build();
    }

    public static ProductOrderResponse createdProductOrderResponseSunshade(){
        return ProductOrderResponse.builder()
                .id(3L)
                .userName("John")
                .productType(ProductType.SUNSHADE)
                .timeHour(3)
                .productValue(40L)
                .productTotal(120L)
                .userAmount(1236L)
                .build();
    }

    public static ProductOrderRequest createProductOrderRequestSandBoard(){
        return ProductOrderRequest.builder()
                .userName("John")
                .productType(ProductType.SAND_BOARD)
                .timeHour(3)
                .build();
    }

    public static ProductOrderResponse createdProductOrderResponseSandBoard(){
        return ProductOrderResponse.builder()
                .id(3L)
                .userName("John")
                .productType(ProductType.SAND_BOARD)
                .timeHour(3)
                .productValue(25L)
                .productTotal(75L)
                .userAmount(675L)
                .build();
    }

    public static ProductOrderRequest createProductOrderRequestBeachTable(){
        return ProductOrderRequest.builder()
                .userName("John")
                .productType(ProductType.BEACH_TABLE)
                .timeHour(3)
                .build();
    }

    public static ProductOrderResponse createdProductOrderResponseBeachTable(){
        return ProductOrderResponse.builder()
                .id(3L)
                .userName("John")
                .productType(ProductType.BEACH_TABLE)
                .timeHour(3)
                .productValue(25L)
                .productTotal(75L)
                .userAmount(607L)
                .build();
    }

    public static Page<ProductOrderResponse> findByProduct(){
        List<ProductOrderResponse> list = new ArrayList<>();
        list.add(createdProductOrderResponseSunshade());
        list.add(createdProductOrderResponseBeachTable());
        list.add(createdProductOrderResponseBeachChair());
        list.add(createdProductOrderResponseSandBoard());
        return new PageImpl<>(list);
    }
}
