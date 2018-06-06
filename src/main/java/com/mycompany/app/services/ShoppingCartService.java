package com.mycompany.app.services;

import com.mycompany.app.common.ConvertEntityToDTO;
import com.mycompany.app.common.ProductDto;
import com.mycompany.app.repository.ProductRepo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ShoppingCartService {
    private ProductDto Prod;// = new Product(1,"Comfy Chair", "OnSale, InStock", 100);
    private InventoryService inventoryService;
    private SalesService salesService;
    private ProductRepo productRepo;
    public boolean addedToCart = false;

    @Inject
    public ShoppingCartService(final InventoryService inventoryservice, final SalesService salesservice, final ProductRepo productRepo)
    {
        //this.Prod = Prod;
        this.inventoryService = inventoryservice;
        this.salesService = salesservice;
        this.productRepo = productRepo;
    }

    public void shoppingCartID(final int ID)
    {
        ConvertEntityToDTO convertDTO = new ConvertEntityToDTO();
        addProduct(convertDTO.ConvertoDTO(productRepo.getOne(ID)));
        //productRepo.save(productRepo.getOne(ID));
    }

    public void addProduct(final ProductDto Prod)
    {
        this.Prod = Prod;
        shoppingCart();
    }

    private void addToCart() //Private as only accessed in this class
    {
        System.out.print("#\tProduct \t:"); System.out.println(Prod.getName()+"\t\t#");
        System.out.print("#\tStatus \t\t:"); System.out.println(Prod.getDescription()+"\t#");
        System.out.print("#\tPrice \t\t:"); System.out.println(salesService.getSalesPrice(Prod)+"\t\t\t\t#");
        addedToCart();
    }

    private void shoppingCart() //Private as only accessed in this class
    {
        if(inventoryService.productsInStock(Prod) > 0) {
            salesService.isOnSale(Prod);
            salesService.getSalesPrice(Prod);
            addToCart();
        }
        else
        {
            System.out.println("#\tNone in stock\t\t\t\t\t#");
        }
    }

    public boolean addedToCart()
    {
        this.addedToCart = true;
        return addedToCart;
    }
}
