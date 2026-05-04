package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.service.dto.CreateProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException;
}
