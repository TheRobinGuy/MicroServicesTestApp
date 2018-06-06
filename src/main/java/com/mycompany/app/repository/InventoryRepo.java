package com.mycompany.app.repository;

import com.mycompany.app.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    @Query("Select ProdQty from Inventory where ProdID = prodID")
    int findByProductID(@Param(("prodID")) int prodID);
}
