package com.diegofer.inventory.model;

import com.diegofer.inventory.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private int inventory_stock;
    private String category;
    private String branchId;

    public Product addStock(int stock){
        this.inventory_stock = this.inventory_stock + stock;
        return this;
    }

}
