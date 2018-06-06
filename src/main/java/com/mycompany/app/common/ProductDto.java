package com.mycompany.app.common;

import com.mycompany.app.entities.Inventory;

import java.math.BigDecimal;

public class ProductDto {
        private int id;
        private String name;
        private String description;
        private BigDecimal price;
        private boolean onSale;
        private BigDecimal salePrice;
        private Inventory inventory;

        public ProductDto(){}

    public ProductDto(final int id, final String name, final String description, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductDto(final ProductBuilder builder) {
        this.id = builder.ID;
        this.name = builder.Name;
        this.description = builder.Description;
        this.price = builder.Price;
        this.onSale = builder.OnSale;
        this.salePrice = builder.SalePrice;
        this.inventory = builder.inventory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /*Builder class for ProductDto*/

    public static class ProductBuilder
    {
        private int ID;
        private String Name;
        private String Description;
        private BigDecimal Price;
        private boolean OnSale;
        private BigDecimal SalePrice;
        private Inventory inventory;

        public ProductBuilder setID(final int id)
        {
            this.ID = id;
            return this;
        }

        public ProductBuilder setName(final String name)
        {
            this.Name = name;
            return this;
        }

        public ProductBuilder setDescription(final String description)
        {
            this.Description = description;
            return this;
        }

        public ProductBuilder setPrice(final BigDecimal price)
        {
            this.Price = price;
            return this;
        }

        public ProductBuilder setSalePrice(final BigDecimal salePrice)
        {
            this.SalePrice = salePrice;
            return this;
        }

        public ProductBuilder setOnSale(final boolean onSale)
        {
            this.OnSale = onSale;
            return this;
        }

        public ProductBuilder setInventory(final Inventory inventory)
        {
            this.inventory = inventory;
            return this;
        }

        public ProductDto build()
        {
            return new ProductDto(this);
        }
    }

}
