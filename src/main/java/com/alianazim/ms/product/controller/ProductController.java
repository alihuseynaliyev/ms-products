package com.alianazim.ms.product.controller;

import com.alianazim.ms.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/cards/{ticketId}")
    public void createCard(@PathVariable Long ticketId){
        productService.processProduct(ticketId);
    }
}
