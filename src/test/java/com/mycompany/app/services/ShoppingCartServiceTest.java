package com.mycompany.app.services;

import com.mycompany.app.repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {
    private InventoryService inventoryService;// = new InventoryService();
    private SalesService salesService = new SalesService();

    @Inject
    private ProductRepo productRepo;

    private ShoppingCartService shoppingCartService = new ShoppingCartService(inventoryService, salesService, productRepo);

    @BeforeEach
    void setUp() {
    }

    @Test
    void shoppingCartID() {
        shoppingCartService.shoppingCartID(1);
        assertTrue(shoppingCartService.addedToCart());
    }

    @Test
    void addProduct() {
    }
}