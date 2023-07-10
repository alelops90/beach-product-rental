package com.salsatechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salsatechnology.model.ProductOrder;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query(value = "SELECT * FROM PRODUCT_ORDER po" +
            " WHERE po.PRODUCT_TYPE = :productType",nativeQuery = true)
    List<ProductOrder> findByProductType(String productType);

}
