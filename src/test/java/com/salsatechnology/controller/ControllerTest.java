package com.salsatechnology.controller;

import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.service.ProductOrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.salsatechnology.mockForTest.MockForTest.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test of Controller")
public class ControllerTest {

    @InjectMocks
    private ProductOrderController productOrderController;

    @Mock
    private ProductOrderService productOrderService;

    @Test
    @DisplayName("Create a new order in DataBase")
    void newOrderSaveWithSucces() {

        BDDMockito.when(productOrderService.createOrder(Mockito.any()))
                .thenReturn(createdProductOrderResponseSurf());

        ProductOrderResponse response = productOrderController.createOrder(Mockito.any()).getBody();
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(ProductType.SURFBOARD);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(150L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(2340L);
    }

    @Test
    @DisplayName("Find order in DataBase")
    void findOrderWithSucces() {

        BDDMockito.when(productOrderService.findByProduct(Mockito.anyString()))
                .thenReturn(findByProduct());

        Page<ProductOrderResponse> responsePage = productOrderController.findByProduct(Mockito.anyString()).getBody();
        Assertions.assertThat(responsePage).isNotNull();
        Assertions.assertThat(responsePage.getTotalPages()).isEqualTo(1);
        Assertions.assertThat(responsePage.getTotalElements()).isEqualTo(4);
    }

}
