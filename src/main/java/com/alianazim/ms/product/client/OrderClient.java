package com.alianazim.ms.product.client;

import com.alianazim.ms.product.model.client.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-order", url = "http://localhost:8081/v1/orders")
public interface OrderClient {

    @GetMapping("/{orderId}")
    ProductResponse getOrder(@PathVariable Long orderId);

    @PutMapping("{orderId}/products/{productId}")
    void updateOrder(@PathVariable Long orderId, @PathVariable Long productId);
}
