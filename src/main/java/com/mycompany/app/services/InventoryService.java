package com.mycompany.app.services;

import com.mycompany.app.common.InventoryDto;
import com.mycompany.app.common.ProductDto;
import com.mycompany.app.entities.Inventory;
import com.mycompany.app.repository.InventoryRepo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InventoryService {

    private InventoryRepo inventoryRepo;

    @Inject
    public InventoryService(final InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public final int productsInStock(final ProductDto Prod){ //Static to access tests

        //Return the number of available products for the inputted ProductID
        int stock = 0;
        if(!Prod.getDescription().toUpperCase().contains("OUTOFSTOCK"))
        {
            stock++;
        }
        return stock;
    }

    public InventoryDto createInventory(final InventoryDto dto) {
        Inventory inventory = new Inventory(dto.getProdID(), dto.getProdQty());

        Inventory result = inventoryRepo.save(inventory);

        return new InventoryDto(result.getID(), result.getProduct(), result.getProdQty());
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }
}
