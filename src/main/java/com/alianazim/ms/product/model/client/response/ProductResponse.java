package com.alianazim.ms.product.model.client.response;

import com.alianazim.ms.product.model.enums.OrderStatus;
import com.alianazim.ms.product.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long orderId;
    private Long userId;
    private Long productId;
    private ProductType productType;
    String details;
}
