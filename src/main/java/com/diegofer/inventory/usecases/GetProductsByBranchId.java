package com.diegofer.inventory.usecases;

import com.diegofer.inventory.dto.ProductDTO;
import com.diegofer.inventory.repository.ProductRepository;
import io.r2dbc.spi.Row;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetProductsByBranchId {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    public Flux<ProductDTO> apply(String branchId){

        return productRepository.findByBranchId(branchId)
                .switchIfEmpty(Flux.error(new IllegalArgumentException("Branch not found")))
                .map(product -> mapper.map(product, ProductDTO.class));
    }
}
