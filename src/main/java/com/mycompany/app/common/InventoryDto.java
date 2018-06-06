package com.mycompany.app.common;

import com.mycompany.app.entities.Product;
import jdk.nashorn.internal.objects.annotations.Constructor;

public class InventoryDto {
    private int ID;
    private Product Prod;
    private int ProdQty;

    public InventoryDto(final Product prod, final int prodQty) {
        this.Prod = prod;
        this.ProdQty = prodQty;
    }

    public InventoryDto() {
    }

    public InventoryDto(final int ID, final Product prod, final int prodQty) {
        this.ID = ID;
        Prod = prod;
        ProdQty = prodQty;
    }

    public int getID() {
        return ID;
    }

    public Product getProdID() {
        return this.Prod;
    }

    public int getProdQty() {
        return ProdQty;
    }


}
