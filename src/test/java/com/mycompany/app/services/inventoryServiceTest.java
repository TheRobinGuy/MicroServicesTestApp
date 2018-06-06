package com.mycompany.app.services;

import com.mycompany.app.common.ProductDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class inventoryServiceTest {
    private ProductDto Prod = new ProductDto(1,"Comfy Chair", "OnSale, InStock", new BigDecimal(100)); //Hard code the product for testing purposes
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void productsInStock() {
       /* InventoryService inventoryService = new InventoryService();
        assertEquals(1, inventoryService.productsInStock(Prod));*/
    }
}