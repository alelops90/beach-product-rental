package com.salsatechnology.service;

import com.salsatechnology.dto.ProductOrderResponse;
import com.salsatechnology.mapper.ProductOrderMapper;
import com.salsatechnology.repository.ProductOrderRepository;
import com.salsatechnology.service.impl.ProductOrderServiceImpl;
import com.salsatechnology.strategy.CalculateOrder;
import com.salsatechnology.strategy.CreateProductOrder;
import com.salsatechnology.strategy.products.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.salsatechnology.mockForTest.MockForTest.*;
import static com.salsatechnology.model.ProductType.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test of Service")
public class ServiceTest {

    @InjectMocks
    private ProductOrderServiceImpl productOrderService;

    @Mock
    private ProductOrderRepository productOrderRepository;

    @Mock
    private ProductOrderMapper productOrderMapper;

    @Mock
    private CalculateOrder calculateOrder;

    @Mock
    private Sunshade sunshade;

    @Mock
    private SandBoard sandBoard;

    @Mock
    private SurfBoard surfBoard;

    @Mock
    private BeachChair beachChair;

    @Mock
    private BeachTable beachTable;

    @Mock
    private CreateProductOrder createProductOrder;

    @Test
    @DisplayName("Create a new order surfboard")

    void newOrderSurfboard() {
        BDDMockito.when(productOrderService.createOrder(createProductOrderRequestSurf()))
                .thenReturn(createdProductOrderResponseSurf());

        ProductOrderResponse response = productOrderService.createOrder(createProductOrderRequestSurf());
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(SURFBOARD);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductValue()).isEqualTo(50L);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(150L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(2340L);
    }

    @Test
    @DisplayName("Create a new order beach chair")
    void newOrderBeachChair() {
        BDDMockito.when(productOrderService.createOrder(createProductOrderRequestBeachChair()))
                .thenReturn(createdProductOrderResponseBeachChair());

        ProductOrderResponse response = productOrderService.createOrder(createProductOrderRequestBeachChair());
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(BEACH_CHAIR);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductValue()).isEqualTo(35L);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(105L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(525L);
    }

    @Test
    @DisplayName("Create a new order sunShade")
    void newOrderSunshade() {
        BDDMockito.when(productOrderService.createOrder(createProductOrderRequestSunshade()))
                .thenReturn(createdProductOrderResponseSunshade());

        ProductOrderResponse response = productOrderService.createOrder(createProductOrderRequestSunshade());
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(SUNSHADE);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductValue()).isEqualTo(40L);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(120L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(1236L);
    }

    @Test
    @DisplayName("Create a new order SandBoard")
    void newOrderSandBoard() {
        BDDMockito.when(productOrderService.createOrder(createProductOrderRequestSandBoard()))
                .thenReturn(createdProductOrderResponseSandBoard());

        ProductOrderResponse response = productOrderService.createOrder(createProductOrderRequestSandBoard());
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(SAND_BOARD);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductValue()).isEqualTo(25L);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(75L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(675L);
    }

    @Test
    @DisplayName("Create a new order beach table")
    void newOrderBeachTable() {
        BDDMockito.when(productOrderService.createOrder(createProductOrderRequestBeachTable()))
                .thenReturn(createdProductOrderResponseBeachTable());

        ProductOrderResponse response = productOrderService.createOrder(createProductOrderRequestBeachTable());
        Assertions.assertThat(response.getId()).isEqualTo(3L);
        Assertions.assertThat(response.getUserName()).isEqualTo("John");
        Assertions.assertThat(response.getProductType()).isEqualTo(BEACH_TABLE);
        Assertions.assertThat(response.getTimeHour()).isEqualTo(3);
        Assertions.assertThat(response.getProductValue()).isEqualTo(25L);
        Assertions.assertThat(response.getProductTotal()).isEqualTo(75L);
        Assertions.assertThat(response.getUserAmount()).isEqualTo(607L);
    }
}
