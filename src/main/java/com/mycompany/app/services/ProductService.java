package com.mycompany.app.services;

import com.mycompany.app.common.ProductDto;
import com.mycompany.app.entities.Inventory;
import com.mycompany.app.entities.Product;
import com.mycompany.app.repository.ProductRepo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class ProductService {

    final private ProductRepo productrepo;
    final private InventoryService inventoryService;


    @Inject
    public ProductService(final ProductRepo productrepo, final InventoryService inventoryService) {
            this.productrepo = productrepo;
            this.inventoryService = inventoryService;
        }

    public Optional<Product> getProd(final int id) {
        return productrepo.findById(id);
    }

    public void deleteProduct(final int id) {
        productrepo.deleteById(id);
    }

    public void deleteProducts() {
        productrepo.deleteAll();
    }

    public List<Product> getProducts() {
        return productrepo.findAll();
    }

    public ProductDto getById(final Integer id) {
        Optional<Product> prod = productrepo.findById(id);

        if (!prod.isPresent()) {
            return null;
        }
        Product p = prod.get();
        return new ProductDto.ProductBuilder().setID(p.getID())
                .setDescription(p.getDescription())
                .setName(p.getName())
                .setOnSale(p.isOnSale())
                .setPrice(p.getPrice())
                .build();
    }

    public ProductDto createProduct(final ProductDto dto) {

        Product prod = new Product(dto.getName(), dto.getDescription(), dto.getPrice(), dto.isOnSale(), dto.getSalePrice());

        Product result = productrepo.save(prod);

        return new ProductDto.ProductBuilder().setID(result.getID())
                .setDescription(result.getDescription())
                .setName(result.getName())
                .setOnSale(result.isOnSale())
                .setPrice(result.getPrice())
                .setInventory(inventoryService.save(new Inventory(result, 1)))
                .build();
    }
}
