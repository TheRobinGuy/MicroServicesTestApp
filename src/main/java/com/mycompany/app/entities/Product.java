package com.mycompany.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;

  @OneToOne(optional = false, mappedBy = "product", cascade = CascadeType.ALL)
  private Inventory inventory;

  @Column(name = "Product_Name")
  private String Name;

  @Column(name = "Product_Description")
  private String Description;

  @Column(name = "Product_Price")
  private BigDecimal Price;

  @Column(name = "Product_OnSale")
  private boolean OnSale;

  @Column(name = "Product_SalePrice")
  private BigDecimal SalePrice;

  public Product(final String name, final String description, final BigDecimal price) {
    this.Name = name;
    this.Description = description;
    this.Price = price;
  }

  public Product(final String name, final String description, final BigDecimal price, final boolean onSale,
      final BigDecimal salePrice) {
    this.Name = name;
    this.Description = description;
    this.Price = price;
    this.OnSale = onSale;
    this.SalePrice = salePrice;
  }

  public Product(final int ID, final String name, final String description, final BigDecimal price,
      final boolean onSale, final BigDecimal salePrice) {
    this.ID = ID;
    this.Name = name;
    this.Description = description;
    this.Price = price;
    this.OnSale = onSale;
    this.SalePrice = salePrice;
  }

  public Product() {
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return Name;
  }

  public String getDescription() {
    return Description;
  }

  public BigDecimal getPrice() {
    return Price;
  }

  public boolean isOnSale() {
    return OnSale;
  }

  public BigDecimal getSalePrice() {
    return SalePrice;
  }
}
