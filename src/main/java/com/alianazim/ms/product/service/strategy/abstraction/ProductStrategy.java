package com.alianazim.ms.product.service.strategy.abstraction;

import com.alianazim.ms.product.model.enums.ProductType;

public interface ProductStrategy {
    boolean supports(ProductType type);
    void execute(Long ticketId, Long orderId, String details);
}
