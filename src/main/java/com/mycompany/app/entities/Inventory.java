package com.mycompany.app.entities;
import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    @JoinColumn(name = "product", nullable = false)
    //@Column(name = "product")
    private Product product;

    @Column(name = "Product_Quantity")
    private int ProdQty;

    public Inventory(/*int ID,*/final Product product, final int prodQty) {
        //this.ID = ID;
        this.product = product;
        this.ProdQty = prodQty;
    }

    public Inventory() {
    }

    public int getID() {
        return ID;
    }

    public Product getProduct() {
        return product;
    }

    public int getProdQty() {
        return ProdQty;
    }
}
