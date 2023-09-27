package com.diegofer.inventory.usecases;

import com.diegofer.inventory.dto.ProductDTO;
import com.diegofer.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddStockToProduct {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public Mono<ProductDTO> apply(String id, int stock) {
        return productRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("product with id: " + id + " was not found")))
                .flatMap(product -> productRepository.save(product.addStock(stock)))
                .map(driverData -> mapper.map(driverData, ProductDTO.class));
    }

}
