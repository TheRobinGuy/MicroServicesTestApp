package com.mycompany.app.common;

import com.mycompany.app.entities.Product;

public class ConvertEntityToDTO {

    public ProductDto ConvertoDTO(final Product product) {
        ProductDto productDto = new ProductDto(product.getID(), product.getName(), product.getDescription(), product.getPrice());
        return productDto;
    }

    public static Product ConvertToEntity(final ProductDto productDto)
    {
        return new Product(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.isOnSale(), productDto.getSalePrice());
    }
}
