package com.diegofer.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private int inventory_stock;
    private String category;
    private String branchId;




}
