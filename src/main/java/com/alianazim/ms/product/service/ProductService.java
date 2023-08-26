package com.alianazim.ms.product.service;

import com.alianazim.ms.product.client.OrderClient;
import com.alianazim.ms.product.client.TicketClient;
import com.alianazim.ms.product.service.strategy.abstraction.ProductStrategy;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final OrderClient orderClient;
    private final TicketClient ticketClient;

    private final List<ProductStrategy> strategies;

    @SneakyThrows
    public void processProduct(Long ticketId) {
        var ticket = ticketClient.getTicket(ticketId);
        var orderId = ticket.getOrderId();
        var order = orderClient.getOrder(orderId);
        var productType = order.getProductType();

        var strategy = strategies.stream()
                .filter(productStrategy -> productStrategy.supports(productType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported product type: " + productType));

        strategy.execute(ticketId, orderId, order.getDetails());
    }
}

