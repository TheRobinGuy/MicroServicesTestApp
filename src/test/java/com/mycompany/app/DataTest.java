package com.mycompany.app;

import com.mycompany.app.common.ProductDto;
import com.mycompany.app.repository.ProductRepo;
import com.mycompany.app.services.ProductService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    @Mock
    ProductRepo productRepo;

    @Mock
    ProductService productService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public BigDecimal MyBigDec = new BigDecimal(102);

    @Before
    public void setUp() {
        when(productService.getById(3)).thenReturn(new ProductDto.ProductBuilder().setID(1)
                                                                    .setName("Name")
                                                                    .setDescription("Description")
                                                                    .setPrice(new BigDecimal(102))
                                                                    .setOnSale(true)
//                                                                    .setSalePrice(new BigDecimal(102).multiply(new BigDecimal(.1)))
                                                                    .setSalePrice(MyBigDec)
                                                                    .build());

//        when(productService.deleteProduct(3)).thenCallRealMethod();
    }

    @Test
    public void findProducts()
    {
        ProductDto product =  productService.getById(3);
        assertFalse(product == null);
    }

    @Test
    public void checkProductName()
    {
        ProductDto productDto = productService.getById(3);
        assertTrue("Name" == productDto.getName());
    }

    @Test
    public void checkSalesPrice()
    {
        ProductDto productDto = productService.getById(3);
//        BigDecimal sales = (productDto.getPrice().multiply( new BigDecimal(.1)));
        BigDecimal sales = (MyBigDec);
        System.out.println(sales);
        System.out.println(productDto.getSalePrice());
        assertTrue(sales == productDto.getSalePrice());
    }
}
