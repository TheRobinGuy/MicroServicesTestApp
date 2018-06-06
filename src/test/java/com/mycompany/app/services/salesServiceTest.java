package com.mycompany.app.services;

import com.mycompany.app.common.ProductDto;
import com.mycompany.app.entities.Inventory;
import com.mycompany.app.entities.Product;
import com.mycompany.app.repository.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class salesServiceTest {
    private ProductDto Prod;
    private SalesService salesService = new SalesService();
    @Inject
    private ProductRepo productRepo ;
    private Inventory inventory;
    private Product product;

    private Boolean ObjectReturned = false;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finished Test");
    }

    @Test
    void isOnSale() {
        assertEquals(true, salesService.isOnSale(Prod));
    }

    @Test
    void isNotOnSale() {
        assertNotEquals(false, salesService.isOnSale(Prod));
    }

    @Test
    void getSalesPrice() {
        assertEquals(90, salesService.getSalesPrice(Prod));
    }

    @Test
    void findProducts()
    {
//        assertNotEquals(true, ObjectReturned);
        System.out.print(productRepo.getOne(2).getName());
    }
}