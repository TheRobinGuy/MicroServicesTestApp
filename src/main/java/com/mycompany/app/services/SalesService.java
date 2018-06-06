package com.mycompany.app.services;

import com.mycompany.app.common.ProductDto;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class SalesService {

    public final boolean isOnSale(final ProductDto Prod) //Static to access tests
    {
        //Returns true if there is any of this product on sale currently
        if(Prod.getDescription().toUpperCase().contains("ONSALE")) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public final BigDecimal getSalesPrice(final ProductDto Prod) //Static to access tests
    {
        //Returns the price of the product that is on sale - 10% of original price
        BigDecimal discountedPrice;
        BigDecimal saleModifier = new BigDecimal(0.10);
        if (isOnSale(Prod))
        {
            discountedPrice = Prod.getPrice().subtract(Prod.getPrice().multiply(saleModifier));
        }
        else
        {
            discountedPrice = Prod.getPrice();
        }
        return discountedPrice;
    }

}
